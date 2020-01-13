package com.usoof.tmdbapp.utils.common

import android.net.Uri
import java.net.URL

object GlideHelper {

    fun getImageUrl(endpoint: String): String {

        val imageUrl = "${Constants.IMAGE_BASE_URL}${Constants.DEFAULT_POSTER_SIZE}$endpoint"

        return imageUrl
    }

}