package com.example.imdbtestapp.di

import com.example.imdbtestapp.data.ImdbMovieDatabase
import com.example.imdbtestapp.network.ImdbService
import com.example.imdbtestapp.repo.MovieRepository
import com.example.imdbtestapp.repo.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(service: ImdbService, database: ImdbMovieDatabase): MovieRepository =
        MovieRepositoryImpl(service, database)
}