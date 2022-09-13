package com.example.tmdbtestapp.mappers

import com.example.tmdbtestapp.data.models.DbMovie
import com.example.tmdbtestapp.models.Movie

fun DbMovie.toApiMovie() =
    Movie(
        id = this.id,
        originalLanguage = this.originalLanguage,
        originalTitle = this.title,
        overview = this.overview,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title
    )

fun Movie.toDbMovie() =
    DbMovie(
        id = this.id,
        originalLanguage = this.originalLanguage,
        originalTitle = this.title,
        overview = this.overview,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title
    )