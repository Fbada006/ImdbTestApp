package com.example.imdbtestapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.imdbtestapp.data.models.DbMovie
import com.example.imdbtestapp.data.models.DbRemoteKeys

@Database(
    entities = [DbMovie::class, DbRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class ImdbMovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}