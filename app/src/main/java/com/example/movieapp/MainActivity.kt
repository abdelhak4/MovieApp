package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.ui.MovieViewModel
import com.example.movieapp.ui.screen.MovieAppScreen
import com.example.movieapp.ui.theme.MovieAppTheme


class MainActivity : ComponentActivity() {
//    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val movieViewModel: MovieViewModel = viewModel(factory = MovieViewModel.Factory)
                    MovieAppScreen(movieViewModel)
                }
            }
        }
    }
}