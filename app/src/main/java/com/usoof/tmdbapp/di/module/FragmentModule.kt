package com.usoof.tmdbapp.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.usoof.tmdbapp.data.repository.MoviesRepository
import com.usoof.tmdbapp.ui.base.BaseFragment
import com.usoof.tmdbapp.ui.movies.MoviesViewModel
import com.usoof.tmdbapp.ui.movies.movies_recycler.MoviesAdapter
import com.usoof.tmdbapp.ui.search.SearchViewModel
import com.usoof.tmdbapp.ui.tv.TvViewModel
import com.usoof.tmdbapp.utils.ViewModelProviderFactory
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideMoviesViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        moviesRepository: MoviesRepository
    ): MoviesViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(MoviesViewModel::class) {
            MoviesViewModel(schedulerProvider, compositeDisposable, networkHelper, moviesRepository, PublishProcessor.create())
        }).get(MoviesViewModel::class.java)

    @Provides
    fun provideMoviesAdapter(): MoviesAdapter = MoviesAdapter(fragment.lifecycle, ArrayList())

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

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