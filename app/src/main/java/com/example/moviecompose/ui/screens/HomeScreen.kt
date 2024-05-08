package com.example.moviecompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable

fun HomeScreen(navigateTo: () -> Unit, navigateTo2: () -> Unit ){

    Scaffold{ paddingValues ->

        Column (modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues), verticalArrangement = Arrangement.Center)
        { Button(onClick = {
            navigateTo()
        })

        {
            Text(text = "Movies")

        }}
        Button(onClick = {

            navigateTo2()

        }) {
            Text(text = "Favorite Movies")

        }
        
            
        
    }
}