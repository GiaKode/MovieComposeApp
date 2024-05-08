package com.example.moviecompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination="Home"){

        composable("Home"){
            HomeScreen (
                navigateTo = {navController.navigate("MovieList")},
                navigateTo2 = {navController.navigate("FavoriteMovies")}

            )
        }

        composable("MovieList"){
            MovieListScreen()
        }

        composable("FavoriteMovies"){
            FavoriteMoviesScreen()
        }

    }



}