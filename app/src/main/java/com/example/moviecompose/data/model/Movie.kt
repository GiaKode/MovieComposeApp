package com.example.moviecompose.data.model

import android.graphics.Movie
import com.google.gson.annotations.SerializedName

data class MovieWrapper(

    @SerializedName("results")
    val movies: List<com.example.moviecompose.data.model.Movie>
)

data class Movie(

    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverange: Double,

    var isFavorite: Boolean = false

)