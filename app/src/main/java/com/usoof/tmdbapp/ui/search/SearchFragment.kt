package com.usoof.tmdbapp.ui.search

import android.os.Bundle
import android.view.View
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.di.component.FragmentComponent
import com.usoof.tmdbapp.ui.base.BaseFragment

class SearchFragment : BaseFragment<SearchViewModel>() {

    companion object {

        const val TAG = "SearchFragment"

        fun newInstance(): SearchFragment {
            val args = Bundle()
            val fragment = SearchFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId(): Int = R.layout.fragment_search

    override fun injectDependencies(fragmentComponent: FragmentComponent) =
        fragmentComponent.inject(this)

    override fun setupView(view: View) {
    }

}