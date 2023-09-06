package com.tirgei.taarifa.di

import com.tirgei.taarifa.core.AndroidDatabaseDriverFactory
import com.tirgei.taarifa.core.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule: Module = module {
    singleOf(::AndroidDatabaseDriverFactory) bind DatabaseDriverFactory::class
}