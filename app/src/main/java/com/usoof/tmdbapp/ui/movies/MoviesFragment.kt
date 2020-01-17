package com.usoof.tmdbapp.ui.movies

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.di.HorizontalLinearLayoutManager
import com.usoof.tmdbapp.di.component.FragmentComponent
import com.usoof.tmdbapp.ui.base.BaseFragment
import com.usoof.tmdbapp.ui.movies.genre_recycler.GenreAdapter
import com.usoof.tmdbapp.ui.movies.movies_recycler.MoviesAdapter
import com.usoof.tmdbapp.utils.log.Logger
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MoviesFragment : BaseFragment<MoviesViewModel>() {

    @Inject
    lateinit var moviesAdapter: MoviesAdapter

    @Inject
    lateinit var genreAdapter: GenreAdapter

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
            it.data?.run {
                Logger.d(TAG, it.toString())
                genreAdapter.appendData(this)
            }
        })

        viewModel.moviesList.observe(this, Observer {
            it.data?.run {
                moviesAdapter.appendData(this)
            }
        })

        viewModel.moviesLoading.observe(this, Observer {
            if (it) {
                progressBar.visibility = VISIBLE
            } else {
                progressBar.visibility = INVISIBLE
            }
        })

    }

    override fun setupView(view: View) {

        LinearSnapHelper().attachToRecyclerView(rv_movies)

        rv_movies.apply {
            layoutManager = linearLayoutManager
            adapter = moviesAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    layoutManager?.run {
                        if (this is LinearLayoutManager
                            && itemCount > 0
                            && itemCount == findLastVisibleItemPosition() + 1
                        ) viewModel.onLoadMore()
                    }
                }
            })
        }

        LinearSnapHelper().attachToRecyclerView(rv_genre)

        rv_genre.apply {
            adapter = genreAdapter
        }


    }

}