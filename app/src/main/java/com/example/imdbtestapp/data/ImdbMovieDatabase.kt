package com.example.imdbtestapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieDao::class],
    version = 1,
    exportSchema = false
)
abstract class ImdbMovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}