package com.example.tmdbtestapp.ui

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.example.tmdbtestapp.mappers.toApiMovie
import com.example.tmdbtestapp.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class TmdbViewmodel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    val movies = repository.getMovies().map { data ->
        data.map { it.toApiMovie() }
    }
}