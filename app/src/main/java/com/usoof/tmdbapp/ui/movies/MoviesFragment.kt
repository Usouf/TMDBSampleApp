package com.usoof.tmdbapp.ui.movies

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.di.component.FragmentComponent
import com.usoof.tmdbapp.ui.base.BaseFragment
import com.usoof.tmdbapp.ui.movies.movies_recycler.MoviesAdapter
import com.usoof.tmdbapp.utils.log.Logger
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MoviesFragment : BaseFragment<MoviesViewModel>() {

    @Inject
    lateinit var moviesAdapter: MoviesAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

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

    override fun setupObservers() {
        super.setupObservers()
        viewModel.genreList.observe(this, Observer {
            it.data?.run { Logger.d(TAG, it.toString()) }
        })

        viewModel.moviesList.observe(this, Observer {
            it.data?.run {
                moviesAdapter.appendData(this)
            }
        })
    }

    override fun setupView(view: View) {

        rv_movies.apply {
            layoutManager = linearLayoutManager
            adapter = moviesAdapter
        }

    }

}