package com.usoof.tmdbapp.ui.movies.movies_recycler

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.di.component.ViewHolderComponent
import com.usoof.tmdbapp.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.item_view_movies.view.*

class MoviesItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<DiscoverMovies, MoviesItemViewModel>(
        R.layout.item_view_movies, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) =
        viewHolderComponent.inject(this)

    override fun setupObservers() {
        super.setupObservers()
        viewModel.dummyText.observe(this, Observer {
            itemView.tv_dummy_item.text = it.name
        })
    }

    override fun setupView(view: View) {
        itemView.tv_dummy_item.setOnClickListener {

        }
    }
}