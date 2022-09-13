package com.example.imdbtestapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class DbMovie(
    @PrimaryKey
    val id: Long,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?
)
