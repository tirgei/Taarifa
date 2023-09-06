package com.tirgei.taarifa.core

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.tirgei.taarifa.database.TaarifaDatabase

class IosDatabaseDriverFactory: DatabaseDriverFactory {
    override fun create(): SqlDriver {
        return NativeSqliteDriver(
            schema = TaarifaDatabase.Schema,
            name = "taarifa.db"
        )
    }
}