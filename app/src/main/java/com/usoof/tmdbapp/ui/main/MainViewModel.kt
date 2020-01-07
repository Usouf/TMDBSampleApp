package com.usoof.tmdbapp.ui.main

import androidx.lifecycle.MutableLiveData
import com.usoof.tmdbapp.ui.base.BaseViewModel
import com.usoof.tmdbapp.utils.common.Event
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val moviesNavigation = MutableLiveData<Event<Boolean>>()
    val searchNavigation = MutableLiveData<Event<Boolean>>()
    val tvNavigation = MutableLiveData<Event<Boolean>>()

    fun onMoviesSelected() {
        moviesNavigation.postValue(Event(true))
    }

    fun onSearchSelected() {
        searchNavigation.postValue(Event(true))
    }

    fun onTvSelected() {
        tvNavigation.postValue(Event(true))
    }

    override fun onCreate() {
        moviesNavigation.postValue(Event(true))
    }

}