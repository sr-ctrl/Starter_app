package com.example.starterapp.movie_retrofit.module

import com.example.starterapp.movie_retrofit.movie_respository.MovieRepository
import com.example.starterapp.movie_retrofit.movie_respository.MovieViewModelFactory
import com.example.starterapp.movie_retrofit.movie_viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ModuleViewModel = module {
    viewModel { MovieViewModel(get()) }
}
val ModuleRepository = module{
    factory { MovieRepository(get()) }
}
val ModuleViewModelFactory = module{
    single { MovieViewModelFactory(get()) }
}





