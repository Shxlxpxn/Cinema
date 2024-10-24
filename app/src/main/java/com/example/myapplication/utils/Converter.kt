package com.example.myapplication.utils


import com.example.myapplication.data.entity.Result
import com.example.myapplication.domain.Film

object Converter {
    fun convertApiListToDtoList(list: List<Result>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            ))
        }
        return result
    }
}