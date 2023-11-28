package com.example.movieapp.data

import com.example.movieapp.model.MovieDetailDto
import com.example.movieapp.model.MovieListDto

interface MovieRepository {
    suspend fun getMovies(): MovieListDto
    suspend fun getMovieDetails(id: Int): MovieDetailDto
}