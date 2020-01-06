package com.usoof.tmdbapp

import android.app.Application
import com.usoof.tmdbapp.di.component.ApplicationComponent
import com.usoof.tmdbapp.di.component.DaggerApplicationComponent
import com.usoof.tmdbapp.di.module.ApplicationModule

class TMDBApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        injectDependencies()
        super.onCreate()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}