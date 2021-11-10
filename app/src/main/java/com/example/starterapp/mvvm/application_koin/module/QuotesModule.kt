package com.example.starterapp.mvvm.application_koin.module

import com.example.starterapp.mvvm.retrofit_viewmodel.QuotesViewmodel
import com.example.starterapp.mvvm.viewmodel_repository.QuotesRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val QuotesViewmodelModule = module {
    viewModel { QuotesViewmodel(get()) }
}

val QuotesRepositoryModule = module{
    factory { QuotesRepository(get()) }
}