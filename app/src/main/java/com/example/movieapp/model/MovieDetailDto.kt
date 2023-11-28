package com.example.movieapp.model

data class MovieDetailDto(
    val backdrop_path: String? = null,
    val genres: List<Genre>? = null,
    val homepage: String? = null,
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double? = null,
    val poster_path: String? = null,
    val release_date: String = "",
    val vote_average: Double? = null,
    val vote_count: Int? = null,
)