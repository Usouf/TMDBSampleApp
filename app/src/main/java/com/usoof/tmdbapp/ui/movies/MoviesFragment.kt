package com.usoof.tmdbapp.ui.movies

import android.os.Bundle
import android.view.View
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.di.component.FragmentComponent
import com.usoof.tmdbapp.ui.base.BaseFragment

class MoviesFragment : BaseFragment<MoviesViewModel>() {

    companion object {

        const val TAG = "MoviesFragment"

        fun newInstance(): MoviesFragment {
            val args = Bundle()
            val fragment = MoviesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId(): Int = R.layout.fragment_movies

    override fun injectDependencies(fragmentComponent: FragmentComponent) =
        fragmentComponent.inject(this)

    override fun setupView(view: View) {
    }


}