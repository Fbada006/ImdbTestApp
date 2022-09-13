package com.example.imdbtestapp.repo

import androidx.paging.*
import com.example.imdbtestapp.data.TmdbMovieDatabase
import com.example.imdbtestapp.data.TmdbRemoteMediator
import com.example.imdbtestapp.data.models.DbMovie
import com.example.imdbtestapp.network.TmdbService
import com.example.imdbtestapp.utils.NETWORK_PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class MovieRepositoryImpl @Inject constructor(
    private val service: TmdbService,
    private val tmdbMovieDatabase: TmdbMovieDatabase
) : MovieRepository {

    override fun getMovies(): Flow<PagingData<DbMovie>> {
        val pagingSourceFactory = { tmdbMovieDatabase.movieDao().getAllMovies() }

        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = TmdbRemoteMediator(
                service,
                tmdbMovieDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}