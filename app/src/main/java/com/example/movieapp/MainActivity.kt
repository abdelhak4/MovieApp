package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.movieapp.model.MovieDetailDto
import com.example.movieapp.model.MovieListDto
import com.example.movieapp.ui.MovieViewModel
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.utils.IMAGE_URL
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
//                    HomePage(movies = movieViewModel.movieUiState, onClick = {})
                    MovieAppScreen(movieViewModel)
                }
            }
        }
    }
}

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

@Composable
fun HomePage(movies: MovieListDto, onClick: (Int) -> Unit) {
    LazyColumn {
        items(movies.results ?: listOf()) { data ->
            Card(
                modifier = Modifier
                    .requiredHeight(200.dp)
                    .padding(12.dp)
                    .clickable { onClick(data.id) },
                colors = CardDefaults.cardColors(Color(0xFF15141F))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    AsyncImage(
                        model = IMAGE_URL + data.posterPath,
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = data.title,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.32.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = data.releaseDate.substring(0..3),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.32.sp)
                    }
                }
            }
        }
    }
}

//#2E1371, #130B2B
//@Preview(showSystemUi = true)
@Composable
fun DetailScreen(movieDetail: MovieDetailDto) {

    Surface(
        contentColor = Color.White,
        color = Color(0xFF15141F),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier,
        ) {
            AsyncImage(
                model = IMAGE_URL + movieDetail.poster_path,
                contentDescription = null,
                modifier = Modifier
                    .requiredHeight(500.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .padding(start = 22.dp, end = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = movieDetail.original_title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.48.sp,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 29.dp)
                            .requiredHeight(height = 24.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(color = Color.White.copy(alpha = 0.05f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = movieDetail.original_language,
                            color = Color(0xffe0e0e0),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Divider(
                    color = Color(0xff515151),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Release date",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.32.sp,
                        )
                        Text(text = movieDetail.release_date)
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Genre",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.32.sp,
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(movieDetail.genres ?: listOf()) {
                                GenreComponent(genre = it.name)
                            }
                        }
                    }
                }
                Divider(
                    color = Color(0xff515151),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp)
                )
                Text(
                    text = movieDetail.overview,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFBCBCBC),
                    letterSpacing = 0.24.sp,
                )
            }
        }
    }
}


@Composable
fun GenreComponent(genre: String) {
    Box(
        modifier = Modifier
            .width(width = if (genre.length >= 9) 100.dp else 50.dp)
            .height(height = 30.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color(0xfffaf0ca).copy(alpha = 0.05f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = genre,
            color = Color(0xffbcbcbc),
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            letterSpacing = 0.24.sp,
            textAlign = TextAlign.Center
        )
    }
}