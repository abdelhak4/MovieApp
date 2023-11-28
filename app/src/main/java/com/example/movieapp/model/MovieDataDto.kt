package com.example.movieapp.model

import com.squareup.moshi.Json

data class MovieDataDto(
    val backdrop_path: String,
//    val genre_ids: List<Int>,
    val id: Int,
//    val original_language: String,
    @field:Json(name  = "original_title")
    val originalTitle: String,
//    val overview: String,
//    val popularity: Double,
    @field:Json(name = "poster_path")
    val posterPath: String,
    @field:Json(name = "release_date")
    val releaseDate: String,
    val title: String,
//    val video: Boolean,
//    val vote_average: Double,
//    val vote_count: Int
)