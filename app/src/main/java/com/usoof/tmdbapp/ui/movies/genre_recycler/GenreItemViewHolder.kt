package com.usoof.tmdbapp.ui.movies.genre_recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.data.model.Genre
import com.usoof.tmdbapp.di.component.ViewHolderComponent
import com.usoof.tmdbapp.ui.base.BaseItemViewHolder
import com.usoof.tmdbapp.utils.display.Toaster
import kotlinx.android.synthetic.main.item_view_genres.view.*

class GenreItemViewHolder(
    parent: ViewGroup
) : BaseItemViewHolder<Genre, GenreItemViewModel>(
    (DataBindingUtil.inflate<ViewDataBinding>(
        LayoutInflater.from(parent.context),
        R.layout.item_view_genres, parent, false
    ))
) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) =
        viewHolderComponent.inject(this)

    override fun setupObservers() {
        super.setupObservers()
//        viewModel.genreName.observe(this, Observer {
//            itemView.tv_genre.text = it
//        })
    }

    override fun setupView(view: View) {

    }
}