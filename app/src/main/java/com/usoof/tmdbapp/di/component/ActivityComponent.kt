package com.usoof.tmdbapp.di.component

import com.usoof.tmdbapp.di.ActivityScope
import com.usoof.tmdbapp.di.module.ActivityModule
import com.usoof.tmdbapp.ui.main.MainActivity
import com.usoof.tmdbapp.ui.movies_detail.MoviesDetailActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: MoviesDetailActivity)
}