package com.example.moviecompose.data.local

import com.example.moviecompose.MyApplication

object MovieDaoFactory {

    fun getMovieDao(): MovieDao{
        return AppDatabase.getInstance(MyApplication.getContext()).movieDao()
    }
}