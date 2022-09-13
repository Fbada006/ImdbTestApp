package com.example.tmdbtestapp.di

import android.content.Context
import androidx.room.Room
import com.example.tmdbtestapp.data.TmdbMovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): TmdbMovieDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TmdbMovieDatabase::class.java,
            "imdbmovies.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}