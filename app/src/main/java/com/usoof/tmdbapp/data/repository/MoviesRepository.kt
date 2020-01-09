package com.usoof.tmdbapp.data.repository

import com.usoof.tmdbapp.data.model.DiscoverMovies
import com.usoof.tmdbapp.data.model.Genre
import com.usoof.tmdbapp.data.remote.NetworkService
import com.usoof.tmdbapp.utils.common.Constants
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun fetchGenres() : Single<List<Genre>> =
        networkService.doGenreCall(Constants.DEFAULT_LANG)
            .map { it.genres }

    fun fetchDiscoverMovies(page: Int): Single<List<DiscoverMovies>> {
        return networkService.doDiscoverMoviesCall(
            Constants.DEFAULT_LANG,
            Constants.DEFAULT_SORT,
            Constants.DEFAULT_ADULT,
            page
        ).map {
            it.results
        }
    }
}