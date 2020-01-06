package com.usoof.tmdbapp.utils.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NetworkError(

    @Expose
    @SerializedName("status_code")
    val status_code: Int,

    @Expose
    @SerializedName("status_message")
    val status_message: String,

    val success: Boolean = false

)
//Invalid API key: You must be granted a valid key.