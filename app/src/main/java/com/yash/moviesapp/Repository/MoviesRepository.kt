package com.yash.moviesapp.Repository

import com.yash.moviesapp.Api.MoviesApi
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi){

    suspend fun getMoviesList() = moviesApi.getMoviesList()

}