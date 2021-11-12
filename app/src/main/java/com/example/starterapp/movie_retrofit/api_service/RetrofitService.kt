package com.example.starterapp.movie_retrofit.api_service

import com.example.starterapp.movie_retrofit.movie_model.Movie
import org.koin.dsl.module
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("movielist.json")
    fun getAllMovies() : Call<List<Movie>>


    }
val retrofitModule = module {

    single {
        RetrofitInstance()
    }

    single {
        get<Retrofit>().create(RetrofitService::class.java)
    }
}
const val BASE_URL = "https://howtodoandroid.com/"
 private fun RetrofitInstance() = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


