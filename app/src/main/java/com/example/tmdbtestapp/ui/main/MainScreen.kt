package com.example.tmdbtestapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tmdbtestapp.models.Movie
import com.example.tmdbtestapp.navigation.MainScreen
import com.example.tmdbtestapp.ui.TmdbViewmodel

@Composable
fun MainScreen(
    tmdbViewmodel: TmdbViewmodel,
    paddingValues: PaddingValues,
    onMovieClick: (movie: Movie) -> Unit
) {
    tmdbViewmodel.setPopState(MainScreen.route)
    Column(
        modifier = Modifier
            .padding(bottom = paddingValues.calculateBottomPadding())
    )
    {
        MovieList(
            movies = tmdbViewmodel.movies,
            modifier = Modifier.fillMaxSize(),
            onMovieClick = onMovieClick
        )
    }
}