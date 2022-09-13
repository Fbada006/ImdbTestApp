package com.example.imdbtestapp.di

import android.content.Context
import androidx.room.Room
import com.example.imdbtestapp.data.ImdbMovieDatabase
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
    fun provideDataBase(@ApplicationContext context: Context): ImdbMovieDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ImdbMovieDatabase::class.java,
            "imdbmovies.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}