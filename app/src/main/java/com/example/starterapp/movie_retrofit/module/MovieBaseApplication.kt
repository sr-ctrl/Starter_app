package com.example.starterapp.movie_retrofit.module

import android.app.Application
import com.example.starterapp.movie_retrofit.api_service.retrofitModule
import com.example.starterapp.movie_retrofit.module.ModuleRepository
import com.example.starterapp.movie_retrofit.module.ModuleViewModel
import com.example.starterapp.movie_retrofit.module.ModuleViewModelFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieBaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieBaseApplication)
            modules(listOf(
                retrofitModule, ModuleViewModel, ModuleRepository, ModuleViewModelFactory
            ))
        }
    }
}