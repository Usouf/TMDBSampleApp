package com.usoof.tmdbapp.ui.tv

import android.os.Bundle
import android.view.View
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.di.component.FragmentComponent
import com.usoof.tmdbapp.ui.base.BaseFragment

class TvFragment : BaseFragment<TvViewModel>() {

    companion object {
        const val TAG = "TvFragment"

        fun newInstance(): TvFragment {
            val args = Bundle()
            val fragment = TvFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId(): Int = R.layout.fragment_tv

    override fun injectDependencies(fragmentComponent: FragmentComponent) =
        fragmentComponent.inject(this)

    override fun setupView(view: View) {
    }

}