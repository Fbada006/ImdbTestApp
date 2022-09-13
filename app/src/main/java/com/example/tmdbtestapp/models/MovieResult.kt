package com.example.tmdbtestapp.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResult(
    val page: Int,
    @Json(name = "results")
    val movieList: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)