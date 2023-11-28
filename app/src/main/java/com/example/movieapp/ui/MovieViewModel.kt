package com.example.movieapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.NetworkMovieRepository
import com.example.movieapp.model.MovieListDto
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieRepository: NetworkMovieRepository
): ViewModel() {
    var movieUiState by mutableStateOf(MovieListDto())
        private set

//    fun loadMovieData() {
//        viewModelScope.launch {
//            movieUiState = try {
//                val movieRepository = NetworkMovieRepository()
////                movieRepository
//            }
//        }
//    }

    companion object {

    }
}