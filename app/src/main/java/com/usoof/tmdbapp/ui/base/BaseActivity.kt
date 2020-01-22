package com.usoof.tmdbapp.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.usoof.tmdbapp.TMDBApp
import com.usoof.tmdbapp.di.component.ActivityComponent
import com.usoof.tmdbapp.di.component.DaggerActivityComponent
import com.usoof.tmdbapp.di.module.ActivityModule
import com.usoof.tmdbapp.utils.display.Toaster
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    lateinit var binding: DB
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, provideLayoutId())
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

    fun showMessage(message: String) = Toaster.show(this, message)
    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    private fun buildActivityComponent() = DaggerActivityComponent
        .builder()
        .activityModule(ActivityModule(this))
        .applicationComponent((application as TMDBApp).applicationComponent)
        .build()

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)
}