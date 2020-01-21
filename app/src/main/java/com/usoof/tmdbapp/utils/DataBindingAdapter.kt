package com.usoof.tmdbapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.utils.common.GlideHelper
import kotlinx.android.synthetic.main.item_view_movies.view.*

@BindingAdapter("posterPath")
fun bindPosterToImageView (view: ImageView, posterPath: String) {
    Glide.with(view.context)
        .load(GlideHelper.getPosterUrl(posterPath))
        .apply(RequestOptions.placeholderOf(R.drawable.ic_photo))
        .into(view)
}