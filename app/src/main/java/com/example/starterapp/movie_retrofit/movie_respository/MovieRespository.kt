package com.example.starterapp.movie_retrofit.movie_respository


import com.example.starterapp.movie_retrofit.api_service.RetrofitService

class MovieRepository (private val retrofitService: RetrofitService) {

     fun getAllMovies() = retrofitService.getAllMovies()
}