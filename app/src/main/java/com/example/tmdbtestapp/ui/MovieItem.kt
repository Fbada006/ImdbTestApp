package com.example.tmdbtestapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tmdbtestapp.models.Movie
import com.example.tmdbtestapp.utils.TMDB_IMAGE_BASE_URL

@Composable
fun MovieItem(movie: Movie) {
    Row(
        modifier = Modifier
			.padding(start = 16.dp, top = 16.dp, end = 16.dp)
			.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieTitle(
            movie.title!!,
            modifier = Modifier.weight(1f)
        )
        MovieImage(
            TMDB_IMAGE_BASE_URL + movie.backdropPath,
            modifier = Modifier
				.padding(start = 16.dp)
				.size(90.dp)
        )
    }
}