package com.example.tmdbtestapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.tmdbtestapp.mappers.toApiMovie
import com.example.tmdbtestapp.models.Movie
import com.example.tmdbtestapp.navigation.popDestinations
import com.example.tmdbtestapp.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TmdbViewmodel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val mutableMovieState: MutableStateFlow<Movie?> = MutableStateFlow(null)
    val movieState = mutableMovieState.asStateFlow()

    private val mutablePopState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val canPopState = mutablePopState.asStateFlow()

    val movies = repository.getMovies()
        .cachedIn(viewModelScope)
        .map { data ->
            data.map { it.toApiMovie() }
        }

    fun getMovieById(movieId: Long?) = viewModelScope.launch {
        mutableMovieState.value = repository.getMovieById(movieId)?.toApiMovie()
    }

    fun setPopState(route: String) {
        mutablePopState.value = popDestinations.contains(route)
    }
}