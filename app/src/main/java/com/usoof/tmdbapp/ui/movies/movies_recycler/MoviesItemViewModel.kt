package com.usoof.tmdbapp.ui.movies.movies_recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.ui.base.BaseItemViewModel
import com.usoof.tmdbapp.utils.common.GlideHelper
import com.usoof.tmdbapp.utils.log.Logger
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MoviesItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<DiscoverMovies>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "MoviesItemViewModel"
    }

    val movieName: LiveData<String> = Transformations.map(data) { it.name }
    val overview: LiveData<String> = Transformations.map(data) { it.overview }
    val voteAverage: LiveData<Double> = Transformations.map(data) { it.voteAverage }
    val posterPath: LiveData<String> = Transformations.map(data) { it.posterPath }


    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }
}