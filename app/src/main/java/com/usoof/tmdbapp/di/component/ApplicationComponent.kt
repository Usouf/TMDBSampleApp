package com.usoof.tmdbapp.di.component

import com.usoof.tmdbapp.TMDBApp
import com.usoof.tmdbapp.data.remote.NetworkService
import com.usoof.tmdbapp.di.module.ApplicationModule
import com.usoof.tmdbapp.utils.network.NetworkHelper
import com.usoof.tmdbapp.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: TMDBApp)

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

    fun getNetworkHelper(): NetworkHelper

    fun getNetworkService(): NetworkService

}