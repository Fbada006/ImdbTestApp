package com.example.imdbtestapp.repo

import androidx.paging.*
import com.example.imdbtestapp.data.ImdbMovieDatabase
import com.example.imdbtestapp.data.ImdbRemoteMediator
import com.example.imdbtestapp.data.models.DbMovie
import com.example.imdbtestapp.mappers.toApiMovie
import com.example.imdbtestapp.models.Movie
import com.example.imdbtestapp.network.ImdbService
import com.example.imdbtestapp.utils.NETWORK_PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class MovieRepositoryImpl @Inject constructor(
    private val service: ImdbService,
    private val imdbMovieDatabase: ImdbMovieDatabase
) : MovieRepository {

    override fun getMovies(): Flow<PagingData<DbMovie>> {
        val pagingSourceFactory = { imdbMovieDatabase.movieDao().getAllMovies() }

        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = ImdbRemoteMediator(
                service,
                imdbMovieDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}