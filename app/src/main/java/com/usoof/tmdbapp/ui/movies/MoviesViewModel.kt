package com.usoof.tmdbapp.ui.movies

import androidx.lifecycle.MutableLiveData
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.data.model.Genre
import com.usoof.tmdbapp.data.repository.MoviesRepository
import com.usoof.tmdbapp.ui.base.BaseViewModel
import com.usoof.tmdbapp.utils.common.Resource
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers

class MoviesViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val moviesRepository: MoviesRepository,
    private val paginator: PublishProcessor<Int?>
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val genreList = MutableLiveData<Resource<List<Genre>>>()

    val moviesList = MutableLiveData<Resource<List<DiscoverMovies>>>()

    val moviesLoading = MutableLiveData<Boolean>()

    var pageNumber: Int = 1

    override fun onCreate() {
        getGenre()
    }

    init {
        compositeDisposable.add(
            paginator
                .onBackpressureDrop()
                .doOnNext {
                    moviesLoading.postValue(true)
                }
                .concatMapSingle { pages ->
                    return@concatMapSingle moviesRepository.fetchDiscoverMovies(pages)
                        .subscribeOn(Schedulers.io())
                        .doOnError { handleNetworkError(it) }

                }.subscribe(
                    {
                        moviesLoading.postValue(false)
                        moviesList.postValue(Resource.success(it))
                    },
                    {
                        handleNetworkError(it)
                    }
                )
        )
    }

    fun getGenre() {
        compositeDisposable.addAll(
            moviesRepository.fetchGenres()
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    {
                        genreList.postValue(Resource.success(it))
                    },
                    {
                        handleNetworkError(it)
                    }
                )
        )
    }

    private fun loadMoreMovies() {
        if (checkInternetConnectionWithMessage()) paginator.onNext(pageNumber)
    }

    fun onLoadMore() {
        if (moviesLoading.value !== null && moviesLoading.value == false) loadMoreMovies()
    }

    fun pageUp() {
        pageNumber++
    }
}