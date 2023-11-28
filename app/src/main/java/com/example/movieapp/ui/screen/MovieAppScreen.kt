package com.example.movieapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.ui.MovieViewModel
import com.example.movieapp.utils.MovieRoutes

@Composable
fun MovieAppScreen(movieViewModel: MovieViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MovieRoutes.Home.name) {
        composable(MovieRoutes.Home.name) {
            HomePage(movies = movieViewModel.movieUiState, onClick = { id ->
                movieViewModel.getMovieDetails(id)
                navController.navigate(MovieRoutes.Details.name)
            })
        }
        composable(MovieRoutes.Details.name) {
            DetailScreen(movieViewModel.movieDetailState)
        }
    }
}
