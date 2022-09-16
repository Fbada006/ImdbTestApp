package com.example.tmdbtestapp.ui

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.example.tmdbtestapp.navigation.DetailScreen
import com.example.tmdbtestapp.repo.MovieRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [32])
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class TmdbViewmodelTest {

    private val movieRepository = mockk<MovieRepository>(relaxed = true)
    private val tmdbViewmodel = TmdbViewmodel(movieRepository)

    @Test
    fun `setting destination sets pop state to true`() = runTest {
        tmdbViewmodel.setPopState(DetailScreen.route)

        tmdbViewmodel.canPopState.test {
            assertThat(awaitItem()).isTrue()
        }
    }

    @Test
    fun `setting destination sets pop state to false`() = runTest {
        tmdbViewmodel.setPopState("a random string")

        tmdbViewmodel.canPopState.test {
            assertThat(awaitItem()).isFalse()
        }
    }
}