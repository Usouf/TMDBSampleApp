package com.usoof.tmdbapp.ui.main

import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import com.usoof.tmdbapp.R
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

    override fun onCreate() {
        moviesNavigation.postValue(Event(true))
    }

    fun onNavigationClick(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.itemMovies -> {
                moviesNavigation.postValue(Event(true))
                true
            }
            R.id.itemTv -> {
                tvNavigation.postValue(Event(true))
                true
            }
            R.id.itemSearch -> {
                searchNavigation.postValue(Event(true))
                true
            }
            else -> false
        }


}