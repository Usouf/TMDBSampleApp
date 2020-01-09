package com.usoof.tmdbapp.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.usoof.tmdbapp.data.model.DiscoverMovies

data class DiscoverResponse(

    @Expose
    @SerializedName("page")
    val page: Int,

    @Expose
    @SerializedName("results")
    val results: List<DiscoverMovies>,

    @Expose
    @SerializedName("total_results")
    val totalResults: Int,

    @Expose
    @SerializedName("total_pages")
    val totalPges: Int

)
//page
//integer
//optional
//results
//array[object]
//{Movie List Result Object}
//optional
//total_results
//integer
//optional
//total_pages
//integer
