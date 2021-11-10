package com.example.starterapp.mvvm.retrofit_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starterapp.mvvm.data.Quotes
import com.example.starterapp.mvvm.viewmodel_repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class QuotesViewmodel (private val quotesRepository: QuotesRepository): ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quotesRepository.getQuote()
        }
    }
    val quote:LiveData<Quotes>
    get() = quotesRepository.quotes
}
