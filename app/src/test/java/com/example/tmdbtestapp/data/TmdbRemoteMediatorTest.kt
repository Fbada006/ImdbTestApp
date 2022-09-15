package com.example.tmdbtestapp.data

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.RemoteMediator
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbtestapp.network.TmdbService
import com.example.tmdbtestapp.pagingState
import com.example.tmdbtestapp.validEmptyMovieResult
import com.example.tmdbtestapp.validMovieResult
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import java.io.IOException

@Config(sdk = [32])
@OptIn(ExperimentalCoroutinesApi::class)
@ExperimentalPagingApi
@RunWith(AndroidJUnit4::class)
class TmdbRemoteMediatorTest {

    private lateinit var movieDao: MovieDao
    private lateinit var db: TmdbMovieDatabase
    private val tmdbService = mockk<TmdbService>()
    private lateinit var mediator: TmdbRemoteMediator

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TmdbMovieDatabase::class.java
        ).build()
        movieDao = db.movieDao()
        mediator = TmdbRemoteMediator(service = tmdbService, tmdbMovieDatabase = db)
    }

    @Test
    fun `refresh load returns success with more data to load`() = runTest {
        coEvery { tmdbService.getMovies(any()) } returns validMovieResult

        val result = mediator.load(LoadType.REFRESH, pagingState)

        assertThat(result).isInstanceOf(RemoteMediator.MediatorResult.Success::class.java)
        assertThat((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached).isFalse()
    }

    @Test
    fun `refresh load returns success and end of pagination true`() = runTest {
        coEvery { tmdbService.getMovies(any()) } returns validEmptyMovieResult

        val result = mediator.load(LoadType.REFRESH, pagingState)
        assertThat(result).isInstanceOf(RemoteMediator.MediatorResult.Success::class.java)
        assertThat((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached).isTrue()
    }

    @Test
    fun `refresh load returns error`() = runTest {
        coEvery { tmdbService.getMovies(any()) } throws IOException()

        val result = mediator.load(LoadType.REFRESH, pagingState)
        assertThat(result).isInstanceOf(RemoteMediator.MediatorResult.Error::class.java)
    }
}