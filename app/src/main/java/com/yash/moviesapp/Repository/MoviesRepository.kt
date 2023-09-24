package com.yash.moviesapp.Repository

import android.util.Log
import com.yash.moviesapp.Api.MoviesApi
import com.yash.moviesapp.Models.MoviesResponse
import com.yash.moviesapp.Utils.Constants
import retrofit2.Response
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi){

    suspend fun getMoviesList():Response<MoviesResponse> {
       return moviesApi.getMoviesList()
    }
}