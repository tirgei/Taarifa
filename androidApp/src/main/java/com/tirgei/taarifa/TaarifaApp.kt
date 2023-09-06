package com.tirgei.taarifa

import android.app.Application
import com.tirgei.taarifa.di.appModule
import com.tirgei.taarifa.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TaarifaApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@TaarifaApp)
            modules(appModule + sharedModule())
        }
    }

}