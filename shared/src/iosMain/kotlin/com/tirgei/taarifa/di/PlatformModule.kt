package com.tirgei.taarifa.di

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.tirgei.taarifa.database.TaarifaDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        NativeSqliteDriver(
            schema = TaarifaDatabase.Schema,
            name = "taarifa.db"
        )
    }
}