package com.example.starterapp.mvvm.viewmodel_repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.starterapp.mvvm.data.Quotes
import com.example.starterapp.mvvm.utils.QuoteService


class QuotesRepository(private val quoteService: QuoteService) {

    private val quoteslivedata = MutableLiveData<Quotes>()

    val quotes:LiveData<Quotes>
    get() = quoteslivedata

    suspend fun getQuote (){
        val result = quoteService.getQuote()
        if (result != null){
//            Log.i("mainn", "getQuote: ${result.body()}")
            quoteslivedata.postValue(result)
            Log.i("quoteRepo", "getQuote:${result} ")
        }
    }
}