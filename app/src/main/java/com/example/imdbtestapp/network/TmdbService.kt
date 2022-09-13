package com.example.imdbtestapp.network

import com.example.imdbtestapp.BuildConfig
import com.example.imdbtestapp.models.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.tmdbApiKey
    ): MovieResult
}