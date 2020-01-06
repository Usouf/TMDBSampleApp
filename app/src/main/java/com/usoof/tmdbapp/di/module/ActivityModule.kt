package com.usoof.tmdbapp.di.module

import androidx.lifecycle.ViewModelProviders
import com.mindorks.bootcamp.instagram.utils.rx.SchedulerProvider
import com.usoof.tmdbapp.ui.base.BaseActivity
import com.usoof.tmdbapp.ui.main.MainViewModel
import com.usoof.tmdbapp.utils.ViewModelProviderFactory
import com.usoof.tmdbapp.utils.network.NetworkHelper
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

}