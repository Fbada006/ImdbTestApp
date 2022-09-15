package com.example.tmdbtestapp

import com.example.tmdbtestapp.data.models.DbMovie

val validEnDbMovie = DbMovie(
    id = 23,
    originalLanguage = "en",
    originalTitle = null,
    overview = null,
    posterPath = null,
    releaseDate = null,
    title = "A title",
    backdropPath = null
)

val validSpanishDbMovie = DbMovie(
    id = 21,
    originalLanguage = "Spanish",
    originalTitle = null,
    overview = null,
    posterPath = null,
    releaseDate = null,
    title = "A Spanish title",
    backdropPath = null
)

val testMovieList = listOf(
    validEnDbMovie, validSpanishDbMovie
)
