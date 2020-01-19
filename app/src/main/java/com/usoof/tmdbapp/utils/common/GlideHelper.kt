package com.usoof.tmdbapp.utils.common

object GlideHelper {

    fun getPosterUrl(endpoint: String): String =
        "${Constants.IMAGE_BASE_URL}${Constants.DEFAULT_POSTER_SIZE}$endpoint"


    fun getBackdropUrl(endpoint: String): String =
        "${Constants.IMAGE_BASE_URL}${Constants.DEFAULT_BACKDROP_SIZE}$endpoint"

}