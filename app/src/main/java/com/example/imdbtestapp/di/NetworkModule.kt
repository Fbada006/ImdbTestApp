package com.example.imdbtestapp.di

import com.example.imdbtestapp.network.ImdbService
import com.example.imdbtestapp.utils.HttpClient
import com.example.imdbtestapp.utils.IMDB_BASE_URL
import com.example.imdbtestapp.utils.LoggingInterceptor
import com.example.imdbtestapp.utils.MoshiBuilder
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
    fun providesImdbService(retrofit: Retrofit): ImdbService =
        retrofit.create(ImdbService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(IMDB_BASE_URL)
        .client(HttpClient.create(LoggingInterceptor.create()))
        .addConverterFactory(MoshiConverterFactory.create(MoshiBuilder.create()))
        .build()
}