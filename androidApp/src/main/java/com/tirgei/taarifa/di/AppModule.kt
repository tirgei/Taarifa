package com.tirgei.taarifa.di

import com.tirgei.taarifa.ui.details.DetailsViewModel
import com.tirgei.taarifa.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Modules used by the android app
 */
val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}