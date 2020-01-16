package com.usoof.tmdbapp.ui.movies.genre_recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.usoof.tmdbapp.data.model.Genre
import com.usoof.tmdbapp.ui.base.BaseItemViewModel
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class GenreItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Genre>(schedulerProvider, compositeDisposable, networkHelper) {

    val genreName: LiveData<String> = Transformations.map(data) { it.name }

    override fun onCreate() {

    }
}