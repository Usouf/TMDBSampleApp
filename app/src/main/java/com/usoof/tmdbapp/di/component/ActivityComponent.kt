package com.usoof.tmdbapp.di.component

import com.usoof.tmdbapp.di.ActivityScope
import com.usoof.tmdbapp.di.module.ActivityModule
import com.usoof.tmdbapp.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}