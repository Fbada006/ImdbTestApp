package com.example.imdbtestapp.mappers

import com.example.imdbtestapp.data.models.DbMovie
import com.example.imdbtestapp.models.Movie

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