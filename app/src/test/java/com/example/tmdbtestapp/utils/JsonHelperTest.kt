package com.example.tmdbtestapp.utils

import com.example.tmdbtestapp.models.Movie
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class JsonHelperTest {

    private val jsonHelper = JsonHelper

    @Test
    fun `given object convert to json`() {
        val movie = Movie(
            id = 0,
            originalLanguage = "en",
            originalTitle = "A title",
            overview = "A title overview",
            backdropPath = null,
            posterPath = null,
            releaseDate = "28/04/22",
            title = "A title"
        )

        val json = jsonHelper.toJson(movie)

        assertThat(json).isNotEmpty()
    }

    @Test
    fun `given movie json convert to movie object`() {
        val json =
            "{\"id\":0,\"original_language\":\"en\",\"original_title\":\"A title\",\"overview\":\"A title overview\",\"release_date\":\"28/04/22\",\"title\":\"A title\"}"

        val movie = jsonHelper.fromJson<Movie>(json)

        assertThat(movie.originalLanguage).isEqualTo("en")
    }
}