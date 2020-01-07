package com.usoof.tmdbapp.di.component

import com.usoof.tmdbapp.di.FragmentScope
import com.usoof.tmdbapp.di.module.FragmentModule
import com.usoof.tmdbapp.ui.movies.MoviesFragment
import com.usoof.tmdbapp.ui.search.SearchFragment
import com.usoof.tmdbapp.ui.tv.TvFragment
import dagger.Component

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [ApplicationComponent::class])
interface FragmentComponent {

    fun inject(fragment: MoviesFragment)

    fun inject(fragment: SearchFragment)

    fun inject(fragment: TvFragment)

}