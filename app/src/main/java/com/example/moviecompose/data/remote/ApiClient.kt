package com.example.moviecompose.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

    private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

    fun getUrl(path : String): String {
        return "$IMAGE_BASE_URL$path"
    }
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}