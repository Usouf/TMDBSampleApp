package com.usoof.tmdbapp.di.component

import com.mindorks.bootcamp.instagram.utils.rx.SchedulerProvider
import com.usoof.tmdbapp.TMDBApp
import com.usoof.tmdbapp.di.module.ApplicationModule
import com.usoof.tmdbapp.utils.network.NetworkHelper
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

}