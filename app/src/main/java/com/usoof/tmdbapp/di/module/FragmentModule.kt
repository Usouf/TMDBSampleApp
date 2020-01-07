package com.usoof.tmdbapp.di.module

import androidx.lifecycle.ViewModelProviders
import com.usoof.tmdbapp.ui.base.BaseFragment
import com.usoof.tmdbapp.ui.movies.MoviesViewModel
import com.usoof.tmdbapp.ui.search.SearchViewModel
import com.usoof.tmdbapp.ui.tv.TvViewModel
import com.usoof.tmdbapp.utils.ViewModelProviderFactory
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideMoviesViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MoviesViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(MoviesViewModel::class) {
            MoviesViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(MoviesViewModel::class.java)

    @Provides
    fun provideTvViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): TvViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(TvViewModel::class){
            TvViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(TvViewModel::class.java)

    @Provides
    fun provideSearchViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): SearchViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(SearchViewModel::class){
            SearchViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(SearchViewModel::class.java)

}