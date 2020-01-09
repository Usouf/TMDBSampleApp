package com.usoof.tmdbapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.usoof.tmdbapp.TMDBApp
import com.usoof.tmdbapp.di.component.DaggerFragmentComponent
import com.usoof.tmdbapp.di.component.FragmentComponent
import com.usoof.tmdbapp.di.module.FragmentModule
import com.usoof.tmdbapp.utils.display.Toaster
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
        setupObservers()
    }

    private fun buildFragmentComponent(): FragmentComponent = DaggerFragmentComponent
        .builder()
        .applicationComponent(((activity!!.application) as TMDBApp).applicationComponent)
        .fragmentModule(FragmentModule(this))
        .build()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(provideLayoutId(), container, false)

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    fun showMessage(message: String) = context?.let { Toaster.show(it, message) }
    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    protected abstract fun setupView(view: View)
}