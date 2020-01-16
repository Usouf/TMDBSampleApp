package com.usoof.tmdbapp.di.component

import com.usoof.tmdbapp.di.ViewHolderScope
import com.usoof.tmdbapp.di.module.ViewHolderModule
import com.usoof.tmdbapp.ui.movies.genre_recycler.GenreItemViewHolder
import com.usoof.tmdbapp.ui.movies.movies_recycler.MoviesItemViewHolder
import dagger.Component

@ViewHolderScope
@Component(modules = [ViewHolderModule::class], dependencies = [ApplicationComponent::class])
interface ViewHolderComponent {

    fun inject(viewHolder: MoviesItemViewHolder)

    fun inject(viewHolder: GenreItemViewHolder)

}