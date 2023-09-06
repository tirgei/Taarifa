package com.tirgei.taarifa.core

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.tirgei.taarifa.database.TaarifaDatabase

class AndroidDatabaseDriverFactory(
    private val context: Context
): DatabaseDriverFactory {
    override fun create(): SqlDriver {
        return AndroidSqliteDriver(
            schema = TaarifaDatabase.Schema,
            context = context,
            name = "taarifa.db"
        )
    }
}