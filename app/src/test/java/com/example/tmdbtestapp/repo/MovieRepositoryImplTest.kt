package com.example.tmdbtestapp.repo

import com.example.tmdbtestapp.data.MovieDao
import com.example.tmdbtestapp.data.TmdbMovieDatabase
import com.example.tmdbtestapp.network.TmdbService
import com.example.tmdbtestapp.validEnDbMovie
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MovieRepositoryImplTest {

    private val database = mockk<TmdbMovieDatabase>()
    private val service = mockk<TmdbService>()
    private val movieDao = mockk<MovieDao>()

    private val repo = MovieRepositoryImpl(service, database)

    @Before
    fun init() {
        every { database.movieDao() } returns movieDao
    }

    @Test
    fun `getting movie from db by id return valid db movie`() = runTest {
        coEvery { movieDao.getMovieById(any()) } returns validEnDbMovie

        val movie = repo.getMovieById(1)

        assertThat(movie).isNotNull()
        assertThat(movie?.id).isEqualTo(23)
        assertThat(movie?.title).isEqualTo("A title")
        assertThat(movie?.originalLanguage).isEqualTo("en")
    }

    @Test
    fun `getting movie from db by id return null`() = runTest {
        coEvery { movieDao.getMovieById(any()) } returns null

        val movie = repo.getMovieById(1)

        assertThat(movie).isNull()
    }
}