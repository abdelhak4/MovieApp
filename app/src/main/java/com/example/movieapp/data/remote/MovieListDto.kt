package com.example.movieapp.data.remote

data class MovieListDto(
    val page: Int,
    val results: List<MovieDataDto>,
//    val total_pages: Int,
//    val total_results: Int
)