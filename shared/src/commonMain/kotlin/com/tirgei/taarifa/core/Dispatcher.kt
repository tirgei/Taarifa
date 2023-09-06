package com.tirgei.taarifa.core

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Defines the dispatcher to use for network requests
 */
interface Dispatcher {
    val io: CoroutineDispatcher
}

internal expect fun provideDispatcher(): Dispatcher