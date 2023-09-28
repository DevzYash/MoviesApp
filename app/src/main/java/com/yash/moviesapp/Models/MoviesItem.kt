package com.yash.moviesapp.Models

data class MoviesItem(
    val backdrop_path: String,
    val id: Int,
    val original_language: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
    val vote_count: Int
)