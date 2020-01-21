package com.usoof.tmdbapp.ui.movies.movies_recycler

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
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
        (DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_view_movies, parent, false
        ))
    ) {

    companion object {
        const val TAG = "MoviesItemViewHolder"
    }

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) =
        viewHolderComponent.inject(this)

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchDetail.observe(this, Observer {
            it?.let {
                val i = Intent(itemView.context, MoviesDetailActivity::class.java)
                i.putExtra("MOVIE", it)
                itemView.context.startActivity(i)
            }
        })

    }

    override fun setupView(view: View) {

    }
}