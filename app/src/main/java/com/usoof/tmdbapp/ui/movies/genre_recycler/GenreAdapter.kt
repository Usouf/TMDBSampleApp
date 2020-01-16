package com.usoof.tmdbapp.ui.movies.genre_recycler

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.usoof.tmdbapp.data.model.Genre
import com.usoof.tmdbapp.ui.base.BaseAdapter

class GenreAdapter(
    parentLifecycle: Lifecycle,
    dataList: ArrayList<Genre>
) : BaseAdapter<Genre, GenreItemViewHolder>(parentLifecycle, dataList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreItemViewHolder =
        GenreItemViewHolder(parent)
}