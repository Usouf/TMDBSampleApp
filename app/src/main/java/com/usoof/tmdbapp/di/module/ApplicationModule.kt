package com.usoof.tmdbapp.di.module

import android.app.Application
import android.content.Context
import com.usoof.tmdbapp.TMDBApp
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.RxSchedulerProvider
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: TMDBApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}