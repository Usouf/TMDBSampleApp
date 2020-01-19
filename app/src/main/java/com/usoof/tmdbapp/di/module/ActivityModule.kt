package com.usoof.tmdbapp.di.module

import androidx.lifecycle.ViewModelProviders
import com.usoof.tmdbapp.ui.base.BaseActivity
import com.usoof.tmdbapp.ui.main.MainViewModel
import com.usoof.tmdbapp.ui.movies_detail.MoviesDetailActivity
import com.usoof.tmdbapp.ui.movies_detail.MoviesDetailViewModel
import com.usoof.tmdbapp.utils.ViewModelProviderFactory
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(MainViewModel::class.java)

    @Provides
    fun provideMoviesDetailViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MoviesDetailViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MoviesDetailViewModel::class) {
            MoviesDetailViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(MoviesDetailViewModel::class.java)

}