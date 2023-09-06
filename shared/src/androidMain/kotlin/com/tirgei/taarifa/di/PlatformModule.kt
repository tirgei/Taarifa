package com.tirgei.taarifa.di

import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.tirgei.taarifa.database.TaarifaDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        AndroidSqliteDriver(
            schema = TaarifaDatabase.Schema,
            context = get(),
            name = "taarifa.db"
        )
    }
}