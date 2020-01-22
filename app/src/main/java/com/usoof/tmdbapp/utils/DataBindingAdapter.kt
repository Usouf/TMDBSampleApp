package com.usoof.tmdbapp.utils

import android.app.Activity
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.core.app.ActivityCompat.startPostponedEnterTransition
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.utils.common.GlideHelper
import com.usoof.tmdbapp.utils.display.ManipulateColor
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.movie_details.view.*

@BindingAdapter("posterPath")
fun bindPosterToImageView(view: ImageView, posterPath: String) {
    Glide.with(view.context)
        .load(GlideHelper.getPosterUrl(posterPath))
        .apply(RequestOptions.placeholderOf(R.drawable.ic_photo))
        .into(view)
}

@BindingAdapter("onNavigationItemSelected")
fun onNavigationItemSelected(
    view: BottomNavigationView,
    listener: OnNavigationItemSelectedListener
) {
    view.setOnNavigationItemSelectedListener(listener)
}

//@BindingAdapter(value = ["backDropPath", "activity"], requireAll = true)
//fun bindBackDropToImageView(view: ImageView, backdropPath: String, activity: Activity) {
//    var colorBasedOnImage: Int = 0
//    Glide.with(view.context)
//        .asBitmap()
//        .load(GlideHelper.getBackdropUrl(backdropPath))
//        .listener(object : RequestListener<Bitmap> {
//            override fun onLoadFailed(
//                e: GlideException?,
//                model: Any?,
//                target: Target<Bitmap>?,
//                isFirstResource: Boolean
//            ): Boolean {
//                startPostponedEnterTransition(activity)
//                return false
//            }
//
//            override fun onResourceReady(
//                resource: Bitmap?,
//                model: Any?,
//                target: Target<Bitmap>?,
//                dataSource: DataSource?,
//                isFirstResource: Boolean
//            ): Boolean {
//                startPostponedEnterTransition(activity)
//                resource?.let {
//                    val p = Palette.from(resource).generate()
//                    colorBasedOnImage = p.getVibrantColor(
//                        ContextCompat.getColor(
//                            view.context.applicationContext,
//                            R.color.colorPrimary
//                        )
//                    )
//
//                    collapsing_tb.setContentScrimColor(
//                        ManipulateColor.manipulateColor(
//                            colorBasedOnImage,
//                            0.62f
//                        )
//                    )
//
//                    activity.window.statusBarColor = ManipulateColor.manipulateColor(
//                        colorBasedOnImage,
//                        0.32f
//                    )
//
//                    i_movie_details.tv_title.setTextColor(
//                        ManipulateColor.manipulateColor(
//                            colorBasedOnImage,
//                            0.62f
//                        )
//                    )
//
//                    i_movie_details.tv_overview.setTextColor(
//                        ManipulateColor.manipulateColor(
//                            colorBasedOnImage,
//                            0.32f
//                        )
//                    )
//
//                    i_movie_details.tv_release.setTextColor(
//                        ManipulateColor.manipulateColor(
//                            colorBasedOnImage,
//                            0.32f
//                        )
//                    )
//
//                    i_movie_details.tv_genre.setTextColor(
//                        ManipulateColor.manipulateColor(
//                            colorBasedOnImage,
//                            0.32f
//                        )
//                    )
//
//
//                }
//                return false
//            }
//        })
//        .apply(RequestOptions.placeholderOf(R.drawable.ic_photo))
//        .apply(RequestOptions().centerInside())
//        .into(view)
//}