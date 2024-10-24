package com.example.myapplication.domain

import com.example.myapplication.data.*
import com.example.myapplication.data.entity.Root
import com.example.myapplication.utils.Converter
import com.example.myapplication.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(API.API_KEY, "ru-RU", page).enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.results))
            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}