package com.usoof.tmdbapp.ui.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.data.model.Genre
import com.usoof.tmdbapp.data.repository.MoviesRepository
import com.usoof.tmdbapp.ui.base.BaseViewModel
import com.usoof.tmdbapp.utils.common.Resource
import com.usoof.tmdbapp.utils.log.Logger
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

    companion object {
        const val TAG = "MoviesViewModel"
    }

    val genreList = MutableLiveData<Resource<List<Genre>>>()

    val moviesList = MutableLiveData<Resource<List<DiscoverMovies>>>()

    val moviesLoading = MutableLiveData<Boolean>()

    var handled = false

    var pageNumber: Int = 0

    override fun onCreate() {
        loadMoreMovies()
        getGenre()
    }

    init {
        Logger.d(TAG, "init")

        compositeDisposable.add(
            paginator
                .onBackpressureDrop()
                .doOnNext {
                    Logger.d(TAG, "doOnNext: $it")
                    moviesLoading.postValue(true)
                }
                .concatMapSingle { pages ->
                    return@concatMapSingle moviesRepository
                        .fetchDiscoverMovies(pages)
                        .subscribeOn(Schedulers.io())
                        .doOnError { handleNetworkError(it) }

                }.subscribe(
                    {
                        Logger.d(TAG, it.toString())
                        moviesLoading.postValue(false)
                        moviesList.postValue(Resource.success(it))
                    },
                    {
                        handleNetworkError(it)
                    }
                )
        )
        Logger.d(TAG, "End init")
    }

    fun getGenre() {
        if (!handled) {
            compositeDisposable.add(
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
            handled = true
        }
    }

    private fun loadMoreMovies() {
        Logger.d(TAG, "loadMoreMovies()")
        pageUp()
        if (checkInternetConnectionWithMessage()) paginator.onNext(pageNumber)
    }

    fun onLoadMore() {
        if (moviesLoading.value !== null && moviesLoading.value == false) loadMoreMovies()
    }

    fun pageUp() {
        pageNumber++
    }
}