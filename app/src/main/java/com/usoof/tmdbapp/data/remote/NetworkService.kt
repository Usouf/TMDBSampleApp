package com.usoof.tmdbapp.data.remote

import com.usoof.tmdbapp.data.remote.response.DiscoverResponse
import com.usoof.tmdbapp.data.remote.response.GenreResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.MOVIES_GENRE)
    fun doGenreCall(
        @Query("language") language: String,
        @Query(Networking.QUERY_API_KEY) apiKey: String = Networking.API_KEY
    ): Single<GenreResponse>

    @GET(Endpoints.DISCOVER_MOVIES)
    fun doDiscoverMoviesCall(
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("include_adult") adult: Boolean,
        @Query("page") page: Int,
        @Query(Networking.QUERY_API_KEY) apiKey: String = Networking.API_KEY
    ): Single<DiscoverResponse>


}