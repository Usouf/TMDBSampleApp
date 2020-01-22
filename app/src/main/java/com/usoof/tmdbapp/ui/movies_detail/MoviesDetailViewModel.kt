package com.usoof.tmdbapp.ui.movies_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.ui.base.BaseViewModel
import com.usoof.tmdbapp.utils.common.FindGenre.getGenresString
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MoviesDetailViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

//    val movieData = MutableLiveData<DiscoverMovies>()

    private val _backdrop = MutableLiveData<String>()

    val backdrop: LiveData<String> = _backdrop

    fun data(movie: DiscoverMovies) {

//        movieData.postValue(movie)

        _backdrop.postValue(movie.backdropPath)
    }

    override fun onCreate() {

    }
}