package com.usoof.tmdbapp.ui.movies.movies_recycler

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.ui.base.BaseAdapter

class MoviesAdapter(
    parentLifecycle: Lifecycle,
    dataList: ArrayList<DiscoverMovies>
) : BaseAdapter<DiscoverMovies, MoviesItemViewHolder>(parentLifecycle, dataList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesItemViewHolder =
        MoviesItemViewHolder(parent)


}