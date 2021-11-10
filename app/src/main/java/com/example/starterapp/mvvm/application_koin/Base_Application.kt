package com.example.starterapp.mvvm.application_koin

import android.app.Application
import com.example.starterapp.mvvm.application_koin.module.QuotesRepositoryModule
import com.example.starterapp.mvvm.application_koin.module.QuotesViewmodelModule
import com.example.starterapp.mvvm.application_koin.module.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Base_Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@Base_Application)
            modules(listOf(
                retrofitModule,QuotesViewmodelModule,QuotesRepositoryModule
            ))
        }
    }
}