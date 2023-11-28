package com.example.movieapp.model

data class MovieListDto(
    val page: Int = 0,
    val results: List<MovieDataDto>? = null,
//    val total_pages: Int,
//    val total_results: Int
)