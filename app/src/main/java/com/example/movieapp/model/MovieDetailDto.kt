package com.example.movieapp.model

data class MovieDetailDto(
    val backdrop_path: String,
    val genres: List<Genre>,
    val homepage: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
    val vote_count: Int
)