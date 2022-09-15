package com.example.tmdbtestapp.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tmdbtestapp.R
import com.example.tmdbtestapp.navigation.DetailScreen
import com.example.tmdbtestapp.ui.MovieImage
import com.example.tmdbtestapp.ui.MovieTitle
import com.example.tmdbtestapp.ui.TmdbViewmodel
import com.example.tmdbtestapp.utils.TMDB_ORIGINAL_IMAGE_BASE_URL

@Composable
fun MovieDetails(
    movieId: Long?,
    modifier: Modifier = Modifier,
    tmdbViewmodel: TmdbViewmodel
) {
    tmdbViewmodel.setPopState(DetailScreen.route)
    tmdbViewmodel.getMovieById(movieId)
    val movie by tmdbViewmodel.movieState.collectAsState()

    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column {
            MovieImage(
                imageUrl = TMDB_ORIGINAL_IMAGE_BASE_URL + movie?.backdropPath,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 220.dp)
            )

            Box(modifier = Modifier.padding(4.dp)) {
                Column {
                    movie?.title?.let { MovieTitle(title = it) }

                    movie?.releaseDate?.let {
                        Text(
                            text = stringResource(id = R.string.release_date, it),
                            style = MaterialTheme.typography.caption
                        )
                    }

                    Spacer(modifier = Modifier.padding(bottom = 2.dp))

                    movie?.overview?.let { Text(text = it) }
                }
            }
        }
    }
}