package com.example.tmdbtestapp.repo

import androidx.paging.PagingData
import com.example.tmdbtestapp.data.models.DbMovie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(): Flow<PagingData<DbMovie>>

    suspend fun getMovieById(movieId: Long?): DbMovie?
}