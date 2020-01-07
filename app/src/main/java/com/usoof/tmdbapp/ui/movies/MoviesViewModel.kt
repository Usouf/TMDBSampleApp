package com.usoof.tmdbapp.ui.movies

import com.usoof.tmdbapp.ui.base.BaseViewModel
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MoviesViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {

    }
}