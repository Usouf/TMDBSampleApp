package com.usoof.tmdbapp.di.component

import com.usoof.tmdbapp.di.ViewHolderScope
import com.usoof.tmdbapp.di.module.ViewHolderModule
import dagger.Component

@ViewHolderScope
@Component(modules = [ViewHolderModule::class], dependencies = [ApplicationComponent::class])
interface ViewHolderComponent {

}