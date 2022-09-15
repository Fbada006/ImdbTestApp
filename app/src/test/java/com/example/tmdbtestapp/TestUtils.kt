package com.example.tmdbtestapp

import androidx.paging.PagingConfig
import androidx.paging.PagingState
import com.example.tmdbtestapp.data.models.DbMovie
import com.example.tmdbtestapp.data.models.DbRemoteKeys
import com.example.tmdbtestapp.mappers.toApiMovie
import com.example.tmdbtestapp.models.MovieResult

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

val validMovieResult = MovieResult(
    page = 2,
    movieList = testMovieList.map { it.toApiMovie() },
    total_pages = 100,
    total_results = 290
)

val validEmptyMovieResult = MovieResult(
    page = 2,
    movieList = emptyList(),
    total_pages = 100,
    total_results = 290
)

val pagingState = PagingState<Int, DbMovie>(
    listOf(),
    null,
    PagingConfig(10),
    10
)