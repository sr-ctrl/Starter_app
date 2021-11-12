package com.example.starterapp.movie_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.starterapp.R
import com.example.starterapp.databinding.ActivityMoviesBinding
import com.example.starterapp.movie_retrofit.movie_viewmodel.MovieViewModel
import com.example.starterapp.movie_retrofit.movie_adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)

        val adapter = MovieAdapter()
        binding.movieRecyclerview.adapter = adapter

        movieViewModel.movieList.observe(this, Observer {
            adapter.setMovieList(it)
        })

        movieViewModel.getAllMovies()

    }
}