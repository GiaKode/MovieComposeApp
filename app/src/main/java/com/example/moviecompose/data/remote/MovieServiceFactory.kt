package com.example.moviecompose.data.remote

object MovieServiceFactory {

    fun getMovieService(): MovieService {
        return ApiClient.getRetrofit().create(MovieService::class.java)
    }

}