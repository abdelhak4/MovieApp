package com.example.movieapp.data

import com.example.movieapp.remote.MovieApiService
import com.example.movieapp.model.MovieListDto

class NetworkMovieRepository(
    private val movieApiService: MovieApiService
): MovieRepository {
    override suspend fun getMovies(): MovieListDto = movieApiService.getMovies()
}