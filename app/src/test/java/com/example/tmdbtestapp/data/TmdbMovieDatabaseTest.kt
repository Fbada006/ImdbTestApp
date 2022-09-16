package com.example.tmdbtestapp.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbtestapp.testKeyList
import com.example.tmdbtestapp.testMovieList
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import java.io.IOException

@Config(sdk = [32])
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class TmdbMovieDatabaseTest {

    private lateinit var movieDao: MovieDao
    private lateinit var keysDao: RemoteKeysDao
    private lateinit var db: TmdbMovieDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TmdbMovieDatabase::class.java
        ).build()
        movieDao = db.movieDao()
        keysDao = db.remoteKeysDao()
    }

    @Test
    @Throws(Exception::class)
    fun `saving movies to database returns non null data`() = runTest {
        movieDao.insertAll(testMovieList)
        val moviedata = movieDao.getAllMovies()
        assertThat(moviedata).isNotNull()
    }

    @Test
    @Throws(Exception::class)
    fun `saving movies to database returns valid movie when querying by id`() = runTest {
        movieDao.insertAll(testMovieList)
        val dbMovie = movieDao.getMovieById(21)
        assertThat(dbMovie).isNotNull()
        assertThat(dbMovie?.id).isEqualTo(21)
        assertThat(dbMovie?.title).isEqualTo("A Spanish title")
    }

    @Test
    @Throws(Exception::class)
    fun `saving movies to database and clearing returns null`() = runTest {
        movieDao.insertAll(testMovieList)
        movieDao.clearMovies()
        val dbMovie = movieDao.getMovieById(21)
        assertThat(dbMovie).isNull()
    }

    @Test
    @Throws(Exception::class)
    fun `saving keys to database returns valid remote key`() = runTest {
        keysDao.insertAll(testKeyList)

        val key = keysDao.remoteKeyMovieId(15)
        assertThat(key).isNotNull()
        assertThat(key?.movieId).isEqualTo(15)
    }

    @Test
    @Throws(Exception::class)
    fun `saving keys to database and clearing returns null key`() = runTest {
        keysDao.insertAll(testKeyList)
        keysDao.clearRemoteKeys()

        val key = keysDao.remoteKeyMovieId(15)
        assertThat(key).isNull()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}