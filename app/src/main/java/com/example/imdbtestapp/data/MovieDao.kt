package com.example.imdbtestapp.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.imdbtestapp.data.models.DbMovie
import com.example.imdbtestapp.models.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies(): PagingSource<Int, DbMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<DbMovie>)

    @Query("DELETE FROM movies")
    suspend fun clearMovies()
}