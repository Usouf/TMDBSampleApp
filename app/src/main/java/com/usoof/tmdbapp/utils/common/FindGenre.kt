package com.usoof.tmdbapp.utils.common

import com.usoof.tmdbapp.data.model.Genre
import com.usoof.tmdbapp.utils.log.Logger
import java.lang.StringBuilder

object FindGenre {

    val genreMap = mutableMapOf<Int, String>()

    fun setGenreMap(genres: List<Genre>) {
        for (genre in genres) {
            genreMap[genre.id] = genre.name
        }
    }

    fun getGenresString(genreIds: List<Int>): String {
        val gs = StringBuilder()

        for (i in genreIds) {
            gs.append(genreMap[i]).append(", ")
            Logger.d("parse genre", gs.toString())
        }
        return gs.toString()
    }

}