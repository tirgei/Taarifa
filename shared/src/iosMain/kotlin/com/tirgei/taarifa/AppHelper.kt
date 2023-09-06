package com.tirgei.taarifa

import com.tirgei.taarifa.di.getBaseModules
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.core.context.startKoin

/**
 * This is used to initialize tools and libraries from the iOS App
 */
fun initApp() {
    Napier.base(DebugAntilog())

    startKoin {
        modules(getBaseModules())
    }
}