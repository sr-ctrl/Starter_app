package com.example.starterapp.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.starterapp.mvvm.retrofit_viewmodel.QuotesViewmodel
import com.example.starterapp.R
import com.example.starterapp.databinding.ActivityRetrofitBinding
import org.koin.androidx.viewmodel.ext.android.viewModel



class Retrofit_Activity : AppCompatActivity() {
    private lateinit var binding:ActivityRetrofitBinding
    private val quotesViewmodel: QuotesViewmodel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)


        quotesViewmodel.quote.observe(this,{
            Log.i("main", "onCreate:${it} ")
            binding.content.text = it.results.toString()
        })

    }
}