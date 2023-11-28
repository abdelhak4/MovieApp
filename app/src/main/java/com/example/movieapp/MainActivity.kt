package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.movieapp.model.MovieListDto
import com.example.movieapp.ui.MovieViewModel
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.utils.MovieRoutes


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
                    HomePage(movies = movieViewModel.movieUiState)
                }
            }
        }
    }
}

@Composable
fun MovieAppScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MovieRoutes.Home.name) {
        composable(MovieRoutes.Home.name) {

        }
        composable(MovieRoutes.Details.name) {

        }
    }
}

@Composable
fun HomePage(movies: MovieListDto) {
    LazyColumn {
        items(movies.results ?: listOf()) { data ->
            Card(
                modifier = Modifier
                    .requiredHeight(200.dp)
                    .padding(12.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500" + data.posterPath,
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = data.title,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = data.releaseDate.substring(0..3))
                    }
                }
            }
        }
    }
}

//#2E1371, #130B2B
@Preview(showSystemUi = true)
@Composable
fun DetailScreen() {
    Surface(
        color = Color(0xff2E1371)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.movie2),
                contentDescription = null,
                modifier = Modifier
                    .requiredHeight(372.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "the title is here")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "released 1999")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "description")
        }
    }
}