package com.tirgei.taarifa.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * The dispatcher used for iOS network requests. iOS doesn't have the IO dispatcher
 * so we use the Default
 */
internal class IosDispatcher: Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.Main
}

internal actual fun provideDispatcher(): Dispatcher = IosDispatcher()