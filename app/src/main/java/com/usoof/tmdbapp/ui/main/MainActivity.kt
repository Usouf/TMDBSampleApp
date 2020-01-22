package com.usoof.tmdbapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.usoof.tmdbapp.R
import com.usoof.tmdbapp.databinding.ActivityMainBinding
import com.usoof.tmdbapp.di.component.ActivityComponent
import com.usoof.tmdbapp.ui.base.BaseActivity
import com.usoof.tmdbapp.ui.movies.MoviesFragment
import com.usoof.tmdbapp.ui.search.SearchFragment
import com.usoof.tmdbapp.ui.tv.TvFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    companion object {

        const val TAG = "MainActivity"

    }

    private var activeFragment: Fragment? = null

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) =
        activityComponent.inject(this)

    override fun setupObservers() {
        super.setupObservers()

        viewModel.moviesNavigation.observe(this, Observer {
            it.getIfNotHandled()?.run { showMovies() }
        })

        viewModel.searchNavigation.observe(this, Observer {
            it.getIfNotHandled()?.run { showSearch() }
        })

        viewModel.tvNavigation.observe(this, Observer {
            it.getIfNotHandled()?.run { showTv() }
        })

    }

    override fun setupView(savedInstanceState: Bundle?) {

        binding.viewModel = viewModel

    }

    private fun showMovies() {
        if (activeFragment is MoviesFragment) return

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment =
            supportFragmentManager.findFragmentByTag(MoviesFragment.TAG) as MoviesFragment?

        if (fragment == null) {
            fragment = MoviesFragment.newInstance()
            fragmentTransaction.add(R.id.containerFragment, fragment, MoviesFragment.TAG)
        } else {
            fragmentTransaction.show(fragment)
        }

        if (activeFragment != null) fragmentTransaction.hide(activeFragment as Fragment)

        fragmentTransaction.commit()

        activeFragment = fragment
    }

    private fun showSearch() {
        if (activeFragment is SearchFragment) return

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment =
            supportFragmentManager.findFragmentByTag(SearchFragment.TAG) as SearchFragment?

        if (fragment == null) {
            fragment = SearchFragment.newInstance()
            fragmentTransaction.add(R.id.containerFragment, fragment, SearchFragment.TAG)
        } else {
            fragmentTransaction.show(fragment)
        }

        if (activeFragment != null) fragmentTransaction.hide(activeFragment as Fragment)

        fragmentTransaction.commit()

        activeFragment = fragment
    }

    private fun showTv() {
        if (activeFragment is TvFragment) return

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment = supportFragmentManager.findFragmentByTag(TvFragment.TAG) as TvFragment?

        if (fragment == null) {
            fragment = TvFragment.newInstance()
            fragmentTransaction.add(R.id.containerFragment, fragment, TvFragment.TAG)
        } else {
            fragmentTransaction.show(fragment)
        }

        if (activeFragment != null) fragmentTransaction.hide(activeFragment as Fragment)

        fragmentTransaction.commit()

        activeFragment = fragment
    }

}
