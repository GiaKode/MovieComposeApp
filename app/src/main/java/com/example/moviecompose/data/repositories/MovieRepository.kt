package com.example.moviecompose.data.repositories

import android.util.Log
import com.example.moviecompose.data.local.MovieDao
import com.example.moviecompose.data.local.MovieDaoFactory
import com.example.moviecompose.data.local.MovieEntity
import com.example.moviecompose.data.model.Movie
import com.example.moviecompose.data.model.MovieWrapper
import com.example.moviecompose.data.remote.MovieService
import com.example.moviecompose.data.remote.MovieServiceFactory
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MovieRepository(private val movieService: MovieService= MovieServiceFactory.getMovieService(),
private val movieDao: MovieDao = MovieDaoFactory.getMovieDao()){

    fun insert(movie: Movie){
        val movieEntity = MovieEntity(movie.id)
        movieDao.insert(movieEntity)
    }

    fun delete(movie: Movie){
        val movieEntity = MovieEntity(movie.id)
        movieDao.delete(movieEntity)
    }

    fun isFavorite(id: Int): Boolean{
        return movieDao.fetchById(id) != null

    }

    fun getFavoriteMovies(): List<Int> {
        val movieEntities = movieDao.fetchAll()
        return movieEntities?.map { it.id } ?: emptyList()
    }

   fun getMovies(path: String, callback: (List<Movie>)-> Unit){
       val getMovies = movieService.getMovies(path)

       getMovies.enqueue(object: Callback<MovieWrapper>{
           override fun onResponse(call: Call<MovieWrapper>, response: Response<MovieWrapper>){

                if(response.isSuccessful){
                    val movies = response.body()?.movies?: emptyList()
                    for (movie in movies){
                        movie.isFavorite = isFavorite(movie.id)
                    }
                    callback(movies)
                }

           }

           override fun onFailure(p0: Call<MovieWrapper>, t: Throwable){

               t.message?.let {
                   Log.d("MovieRepository", it)
               }

           }
       })
   }

}