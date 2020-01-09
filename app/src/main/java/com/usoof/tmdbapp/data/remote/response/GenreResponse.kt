package com.usoof.tmdbapp.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.usoof.tmdbapp.data.model.Genre

data class GenreResponse(

    @Expose
    @SerializedName("genres")
    val genres: List<Genre>
)