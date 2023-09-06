package com.tirgei.taarifa.di

import com.tirgei.taarifa.core.DatabaseDriverFactory
import com.tirgei.taarifa.core.IosDatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule: Module = module {
    singleOf(::IosDatabaseDriverFactory) bind DatabaseDriverFactory::class
}