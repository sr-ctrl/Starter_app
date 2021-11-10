package com.example.starterapp.mvvm.application_koin.module

import com.example.starterapp.mvvm.utils.QuoteService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://quotable.io"

val retrofitModule = module {

    single {
        retrofit(BASE_URL)
    }

    single {
        get<Retrofit>().create(QuoteService::class.java)
    }
}


private fun retrofit(baseUrl: String) = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


