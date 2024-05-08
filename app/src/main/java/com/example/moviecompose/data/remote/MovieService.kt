package com.example.moviecompose.data.remote

import com.example.moviecompose.data.model.MovieWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("{endpoint}")
    fun getMovies(@Path("endpoint") path: String,
                  @Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325"
    ): Call<MovieWrapper>
}