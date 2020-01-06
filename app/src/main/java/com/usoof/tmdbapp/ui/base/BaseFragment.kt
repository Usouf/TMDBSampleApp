package com.usoof.tmdbapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.usoof.tmdbapp.di.component.DaggerFragmentComponent
import com.usoof.tmdbapp.di.component.FragmentComponent
import com.usoof.tmdbapp.di.module.FragmentModule

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
    }

    private fun buildFragmentComponent(): FragmentComponent = DaggerFragmentComponent
        .builder()
        .fragmentModule(FragmentModule(this))
        .build()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(provideLayoutId(), container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)
}