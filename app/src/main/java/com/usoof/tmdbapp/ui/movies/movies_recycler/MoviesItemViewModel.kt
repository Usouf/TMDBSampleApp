package com.usoof.tmdbapp.ui.movies.movies_recycler

import androidx.lifecycle.MutableLiveData
import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.ui.base.BaseItemViewModel
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

    val launchDetail = MutableLiveData<DiscoverMovies>()

    fun launchDetailActivity(movie: DiscoverMovies) {
        launchDetail.postValue(movie)
    }

    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }
}