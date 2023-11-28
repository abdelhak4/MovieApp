package com.example.movieapp.remote

import com.example.movieapp.model.MovieDetailDto
import com.example.movieapp.model.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("discover/movie?include_adult=false&include_video=false&language=en-US&page=2&sort_by=popularity.desc")
    suspend fun getMovies(): MovieListDto

    @GET("movie")
    suspend fun getDetails(
        @Query("movie_id") movieId: Int,
        @Query("language") language: String = "en-US",
    ): MovieDetailDto
}