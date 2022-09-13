package com.example.tmdbtestapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbtestapp.data.models.DbMovie
import com.example.tmdbtestapp.data.models.DbRemoteKeys

@Database(
    entities = [DbMovie::class, DbRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class TmdbMovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}