package com.example.moviecompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert
    fun insert(movieEntity: MovieEntity)

    @Delete
    fun delete(movieEntity: MovieEntity)

    @Query("select * from movies where id=:id")
    fun fetchById(id: Int): MovieEntity?

    @Query("select * from movies")
    fun fetchAll(): List<MovieEntity>?
}