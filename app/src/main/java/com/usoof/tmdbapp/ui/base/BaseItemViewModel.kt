package com.usoof.tmdbapp.ui.base

import androidx.lifecycle.MutableLiveData
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseItemViewModel<T: Any>(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val data = MutableLiveData<T>()

    fun onManualClear() = onCleared()

    fun updateData(data: T) {
        this.data.postValue(data)
    }
}