package com.tirgei.taarifa

import android.app.Application
import android.content.Context
import com.tirgei.taarifa.di.appModule
import com.tirgei.taarifa.di.getBaseModules
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class TaarifaApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Napier.base(DebugAntilog())
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@TaarifaApp)
            modules(appModule + getBaseModules())
        }
    }

}