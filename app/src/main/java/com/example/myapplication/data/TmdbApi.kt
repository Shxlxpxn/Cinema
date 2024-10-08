package com.example.myapplication.data

import android.telecom.Call
import androidx.room.Query
import com.example.myapplication.data.entity.TmdbResults
import retrofit2.http.GET

interface TmdbApi {
    @GET("3/movie/popular")
    fun getFilms(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<TmdbResults>
}