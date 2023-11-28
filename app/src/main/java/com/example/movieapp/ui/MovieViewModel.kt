package com.example.movieapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.movieapp.MovieApp
import com.example.movieapp.data.MovieRepository
import com.example.movieapp.model.MovieListDto
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    init {
        loadMovieData()
    }

    var movieUiState by mutableStateOf(MovieListDto())
        private set

    private fun loadMovieData() {
        viewModelScope.launch {
            try {
            movieUiState = movieRepository.getMovies()
            } catch (e: Exception) {
                println( e.message)
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MovieApp)
                val movieRepository = application.container.movieRepository
                MovieViewModel(movieRepository)
            }
        }
    }
}