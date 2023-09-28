package com.yash.moviesapp.Api

import com.yash.moviesapp.Models.MoviesResponse
import com.yash.moviesapp.Utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET(Constants.MOVIES_NOW_PLAYING)
    suspend fun getMoviesList(
        @Query("page") page: Int,
        @Query("region") region: String
    ): Response<MoviesResponse>
}