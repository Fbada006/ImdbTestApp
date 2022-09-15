package com.example.tmdbtestapp.network

import com.example.tmdbtestapp.BuildConfig
import com.example.tmdbtestapp.models.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.tmdbApiKey
    ): MovieResult
}