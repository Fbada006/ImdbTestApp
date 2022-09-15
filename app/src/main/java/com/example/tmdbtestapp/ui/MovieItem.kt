package com.example.tmdbtestapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tmdbtestapp.models.Movie
import com.example.tmdbtestapp.utils.TMDB_IMAGE_BASE_URL

@Composable
fun MovieItem(movie: Movie, modifier: Modifier) {

    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MovieImage(
                TMDB_IMAGE_BASE_URL + movie.backdropPath,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 180.dp)
            )

            MovieTitle(
                movie.title!!,
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}