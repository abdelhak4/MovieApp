package com.example.movieapp.ui.screen

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
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
import coil.compose.AsyncImage
import com.example.movieapp.model.MovieDetailDto
import com.example.movieapp.utils.IMAGE_URL

@Composable
fun DetailScreen(movieDetail: MovieDetailDto) {

    Surface(
        contentColor = Color.White, color = Color(0xFF15141F), modifier = Modifier.fillMaxSize()
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
                modifier = Modifier.padding(start = 22.dp, end = 24.dp),
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
                    modifier = Modifier.fillMaxWidth(),
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