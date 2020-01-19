package com.usoof.tmdbapp.ui.movies_detail

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

    val title = MutableLiveData<String>()
    val genres = MutableLiveData<String>()
    val releaseData = MutableLiveData<String>()
    val vote = MutableLiveData<String>()
    val overview = MutableLiveData<String>()
    val backdrop = MutableLiveData<String>()
    val poster = MutableLiveData<String>()

    fun data(movie: DiscoverMovies) {

//        movieData.postValue(movie)

        title.postValue(movie.name)
        releaseData.postValue(movie.releaseDate)
        vote.postValue(movie.voteAverage.toString())
        overview.postValue(movie.overview)
        genres.postValue(getGenresString(movie.genreIds))
        backdrop.postValue(movie.backdropPath)
        poster.postValue(movie.posterPath)
    }

    override fun onCreate() {

    }
}