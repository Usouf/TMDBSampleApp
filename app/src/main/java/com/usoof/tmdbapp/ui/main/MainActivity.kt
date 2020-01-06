package com.usoof.tmdbapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.di.component.ActivityComponent
import com.usoof.tmdbapp.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) =
        activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {

    }
}
