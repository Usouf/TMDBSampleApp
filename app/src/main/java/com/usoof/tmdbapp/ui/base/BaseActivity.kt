package com.usoof.tmdbapp.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.usoof.tmdbapp.di.component.ActivityComponent
import com.usoof.tmdbapp.di.component.DaggerActivityComponent
import com.usoof.tmdbapp.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<VM: BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

    open fun setupObservers() {
        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    fun showMessage(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    private fun buildActivityComponent() = DaggerActivityComponent
        .builder()
        .activityModule(ActivityModule(this))
        .build()

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)
}