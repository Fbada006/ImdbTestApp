package com.example.imdbtestapp.repo

import androidx.paging.PagingData
import com.example.imdbtestapp.data.models.DbMovie
import com.example.imdbtestapp.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(): Flow<PagingData<DbMovie>>
}