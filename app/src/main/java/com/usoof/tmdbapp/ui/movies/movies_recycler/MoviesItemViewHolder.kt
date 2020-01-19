package com.usoof.tmdbapp.ui.movies.movies_recycler

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.di.component.ViewHolderComponent
import com.usoof.tmdbapp.ui.base.BaseItemViewHolder
import com.usoof.tmdbapp.ui.movies_detail.MoviesDetailActivity
import com.usoof.tmdbapp.utils.common.GlideHelper
import com.usoof.tmdbapp.utils.log.Logger
import kotlinx.android.synthetic.main.item_view_movies.view.*

class MoviesItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<DiscoverMovies, MoviesItemViewModel>(
        R.layout.item_view_movies, parent
    ) {

    companion object {
        const val TAG = "MoviesItemViewHolder"
    }

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) =
        viewHolderComponent.inject(this)

    override fun setupObservers() {
        super.setupObservers()
        viewModel.movieName.observe(this, Observer {
            itemView.tv_movieTitle.text = it
        })

        viewModel.overview.observe(this, Observer {
            itemView.tv_movieOverview.text = it
        })

        viewModel.voteAverage.observe(this, Observer {
            itemView.tv_movieVote.text = it.toString()
        })

        viewModel.posterPath.observe(this, Observer {
            Glide.with(itemView.iv_moviePoster.context)
                .load(GlideHelper.getPosterUrl(it))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_photo))
                .into(itemView.iv_moviePoster)

//            Logger.d(TAG, "image endpoint: $it")
        })

        viewModel.launchDetail.observe(this, Observer {
            val i = Intent(itemView.context, MoviesDetailActivity::class.java)
            Logger.d(TAG, it.toString())
            i.putExtra("MOVIE", it)
            itemView.context.startActivity(i)
        })
    }

    override fun setupView(view: View) {

        itemView.cl_item_movie.setOnClickListener {
            viewModel.launchDetailActivity()
        }

    }
}