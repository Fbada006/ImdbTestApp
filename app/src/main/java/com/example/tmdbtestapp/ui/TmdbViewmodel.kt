package com.example.tmdbtestapp.ui

import androidx.lifecycle.ViewModel
import com.example.tmdbtestapp.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TmdbViewmodel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    val movies = repository.getMovies()
}