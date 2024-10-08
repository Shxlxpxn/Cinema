package com.example.myapplication.domain

import android.telecom.Call
import android.view.WindowInsetsAnimation
import com.example.myapplication.data.*
import com.example.myapplication.data.entity.TmdbResults
import com.example.myapplication.utils.Converter
import com.example.myapplication.viewmodel.HomeFragmentViewModel
import okhttp3.Response


class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {

    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(API.KEY, "ru-RU", page).enqueue(object :
            WindowInsetsAnimation.Callback<TmdbResults> {
            override fun onResponse(call: Call<TmdbResults>, response: Response<TmdbResults>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                callback.onSuccess(Converter.convertApiListToDTOList(response.body()?.tmdbFilms))
            }

            override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}