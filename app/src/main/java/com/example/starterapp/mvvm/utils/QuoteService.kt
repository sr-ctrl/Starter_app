package com.example.starterapp.mvvm.utils

import com.example.starterapp.mvvm.data.Quotes
import retrofit2.http.GET

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuote():Quotes
}