package com.example.tmdbtestapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.PagingData
import com.example.tmdbtestapp.models.Movie
import com.example.tmdbtestapp.navigation.MainScreen
import kotlinx.coroutines.flow.Flow

@Composable
fun MainScreen(
    movies: Flow<PagingData<Movie>>,
    setPopState: (route: String) -> Unit,
    paddingValues: PaddingValues,
    onMovieClick: (movie: Movie) -> Unit
) {
    setPopState(MainScreen.route)
    Column(
        modifier = Modifier
            .padding(bottom = paddingValues.calculateBottomPadding())
    )
    {
        MovieList(
            movies = movies,
            modifier = Modifier.fillMaxSize(),
            onMovieClick = onMovieClick
        )
    }
}