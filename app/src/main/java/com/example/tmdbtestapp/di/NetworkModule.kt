package com.example.tmdbtestapp.di

import com.example.tmdbtestapp.network.TmdbService
import com.example.tmdbtestapp.utils.HttpClient
import com.example.tmdbtestapp.utils.TMDB_BASE_URL
import com.example.tmdbtestapp.utils.LoggingInterceptor
import com.example.tmdbtestapp.utils.MoshiBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesTmdbService(retrofit: Retrofit): TmdbService =
        retrofit.create(TmdbService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(TMDB_BASE_URL)
        .client(HttpClient.create(LoggingInterceptor.create()))
        .addConverterFactory(MoshiConverterFactory.create(MoshiBuilder.create()))
        .build()
}