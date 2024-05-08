package com.example.moviecompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.moviecompose.data.model.Movie
import com.example.moviecompose.data.repositories.MovieRepository

@Composable
fun FavoriteMoviesScreen(movieRepository: MovieRepository = MovieRepository()) {
    val favoriteMoviesIds = remember { mutableStateOf(emptyList<Int>()) }
    val allMovies = remember { mutableStateOf(emptyList<Movie>()) }


    LaunchedEffect(key1 = Unit) {
        favoriteMoviesIds.value = movieRepository.getFavoriteMovies()
    }

    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            favoriteMoviesIds.value.forEach { movieId ->
                Text(text = "Movie ID: $movieId")
            }
        }
    }
}