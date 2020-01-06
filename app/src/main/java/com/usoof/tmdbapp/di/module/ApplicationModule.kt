package com.usoof.tmdbapp.di.module

import com.usoof.tmdbapp.TMDBApp
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: TMDBApp) {

    @Provides
    fun provideApplication() = application

    @Provides
    fun provideApplicationContext() = application
}