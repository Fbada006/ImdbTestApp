package com.example.tmdbtestapp

import com.example.tmdbtestapp.data.models.DbMovie
import com.example.tmdbtestapp.data.models.DbRemoteKeys

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

val testKeyList = listOf(
    DbRemoteKeys(movieId = 12, prevKey = null, nextKey = null),
    DbRemoteKeys(movieId = 15, prevKey = null, nextKey = null)
)
