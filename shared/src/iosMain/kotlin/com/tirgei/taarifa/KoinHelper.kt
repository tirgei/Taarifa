package com.tirgei.taarifa

import com.tirgei.taarifa.di.sharedModule
import org.koin.core.context.startKoin

/**
 * This is used to initialize Koin from the iOS App
 */
fun initKoin() {
    startKoin {
        modules(sharedModule())
    }
}