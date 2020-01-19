package com.usoof.tmdbapp.ui.movies_detail

import android.graphics.Bitmap
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.di.component.ActivityComponent
import com.usoof.tmdbapp.ui.base.BaseActivity
import com.usoof.tmdbapp.utils.common.GlideHelper
import com.usoof.tmdbapp.utils.display.ManipulateColor
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.movie_details.view.*

class MoviesDetailActivity : BaseActivity<MoviesDetailViewModel>() {

    var colorBasedOnImage: Int = 0

    override fun provideLayoutId(): Int = R.layout.activity_movie_detail

    override fun injectDependencies(activityComponent: ActivityComponent) =
        activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {

        setUpActionBar()
        viewModel.data(intent.getParcelableExtra("MOVIE"))

    }

    private fun setUpActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.title.observe(this, Observer {
            i_movie_details.tv_title.text = it
        })

        viewModel.genres.observe(this, Observer {
            i_movie_details.tv_genre.text = it
        })

        viewModel.releaseData.observe(this, Observer {
            i_movie_details.tv_release.text = it
        })

        viewModel.vote.observe(this, Observer {
            i_movie_details.tv_vote.text = it
        })

        viewModel.overview.observe(this, Observer {
            i_movie_details.tv_overview.text = it
        })

        viewModel.backdrop.observe(this, Observer {
            Glide.with(this)
                .asBitmap()
                .load(GlideHelper.getBackdropUrl(it))
                .listener(object : RequestListener<Bitmap> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Bitmap>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        startPostponedEnterTransition()
                        return false
                    }

                    override fun onResourceReady(
                        resource: Bitmap?,
                        model: Any?,
                        target: Target<Bitmap>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        startPostponedEnterTransition()
                        resource?.let {
                            val p = Palette.from(resource).generate()
                            colorBasedOnImage = p.getVibrantColor(
                                ContextCompat.getColor(
                                    applicationContext,
                                    R.color.colorPrimary
                                )
                            )

                            collapsing_tb.setContentScrimColor(
                                ManipulateColor.manipulateColor(
                                    colorBasedOnImage,
                                    0.62f
                                )
                            )

                            getWindow().setStatusBarColor(
                                ManipulateColor.manipulateColor(
                                    colorBasedOnImage,
                                    0.32f
                                )
                            )

                            i_movie_details.tv_title.setTextColor(
                                ManipulateColor.manipulateColor(
                                    colorBasedOnImage,
                                    0.62f
                                )
                            )

                            i_movie_details.tv_overview.setTextColor(
                                ManipulateColor.manipulateColor(
                                    colorBasedOnImage,
                                    0.32f
                                )
                            )

                            i_movie_details.tv_release.setTextColor(
                                ManipulateColor.manipulateColor(
                                    colorBasedOnImage,
                                    0.32f
                                )
                            )

                            i_movie_details.tv_genre.setTextColor(
                                ManipulateColor.manipulateColor(
                                    colorBasedOnImage,
                                    0.32f
                                )
                            )


                        }
                        return false
                    }
                })
                .apply(RequestOptions.placeholderOf(R.drawable.ic_photo))
                .apply(RequestOptions().centerInside())
                .into(iv_backdrop)
        })

        viewModel.poster.observe(this, Observer {
            Glide.with(this)
                .load(GlideHelper.getPosterUrl(it))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_photo))
                .apply(RequestOptions().centerInside())
                .into(iv_poster)
        })
    }


}