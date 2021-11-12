package com.example.starterapp.movie_retrofit.movie_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starterapp.movie_retrofit.movie_respository.MovieRepository
import com.example.starterapp.movie_retrofit.movie_model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel (private val repository: MovieRepository)  : ViewModel() {

    val _movieList = MutableLiveData<List<Movie>>()
    val movieList :LiveData<List<Movie>>
    get() = _movieList
    val errorMessage = MutableLiveData<String>()
    fun getAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllMovies()
            response.enqueue(object : Callback<List<Movie>> {
                override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                    _movieList.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }

    }
}