package com.example.tmdbtestapp.di

import com.example.tmdbtestapp.data.TmdbMovieDatabase
import com.example.tmdbtestapp.network.TmdbService
import com.example.tmdbtestapp.repo.MovieRepository
import com.example.tmdbtestapp.repo.MovieRepositoryImpl
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
    fun provideRepository(service: TmdbService, database: TmdbMovieDatabase): MovieRepository =
        MovieRepositoryImpl(service, database)
}