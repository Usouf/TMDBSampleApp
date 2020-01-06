package com.usoof.tmdbapp.di.component

import com.usoof.tmdbapp.TMDBApp
import com.usoof.tmdbapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: TMDBApp)

}