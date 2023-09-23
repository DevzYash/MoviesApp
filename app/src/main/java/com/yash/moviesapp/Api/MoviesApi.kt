package com.yash.moviesapp.Api

import com.yash.moviesapp.Models.MoviesItem
import com.yash.moviesapp.Models.MoviesResponse
import com.yash.moviesapp.Utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {

    @GET(Constants.MOVIES_NOW_PLAYING)
    suspend fun getMoviesList():Response<MoviesResponse>
}