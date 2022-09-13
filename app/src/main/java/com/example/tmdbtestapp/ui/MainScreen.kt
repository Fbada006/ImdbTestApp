package com.example.tmdbtestapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    viewmodel: TmdbViewmodel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(bottom = paddingValues.calculateBottomPadding())
    )
    { MovieList(movies = viewmodel.movies) }

}