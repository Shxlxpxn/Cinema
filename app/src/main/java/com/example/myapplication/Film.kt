package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val title: String = "",
    val poster: Int = 0,
    val description: String = "",
    val rating: Float = 0f,
    var isInFavorites: Boolean = false
) : Parcelable