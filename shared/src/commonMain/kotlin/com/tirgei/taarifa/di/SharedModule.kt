package com.tirgei.taarifa.di

import com.tirgei.taarifa.core.provideDispatcher
import com.tirgei.taarifa.data.repositories.NewsRepository
import com.tirgei.taarifa.domain.respositories.INewsRepository
import org.koin.dsl.module

/**
 * Modules used by both platforms
 */
fun sharedModule() = module {
    // Dispatcher
    factory { provideDispatcher() }

    // Repositories
    single<INewsRepository> { NewsRepository(get()) }

}