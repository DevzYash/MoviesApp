package com.yash.moviesapp.Repository

import com.yash.moviesapp.Api.MoviesApi
import com.yash.moviesapp.Models.MoviesResponse
import retrofit2.Response
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi) {

    suspend fun getMoviesList(page: Int, region: String): Response<MoviesResponse> {
        return moviesApi.getMoviesList(page, region)
    }
}