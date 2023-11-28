package com.example.movieapp.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.model.MovieListDto
import com.example.movieapp.utils.IMAGE_URL


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