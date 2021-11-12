package com.example.starterapp.movie_retrofit.movie_respository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starterapp.movie_retrofit.movie_viewmodel.MovieViewModel

class MovieViewModelFactory (private val repository: MovieRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            MovieViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}