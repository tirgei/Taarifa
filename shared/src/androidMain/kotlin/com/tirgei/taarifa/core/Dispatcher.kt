package com.tirgei.taarifa.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * The dispatcher to use for the android app network requests i.e IO dispatcher
 */
internal class AndroidDispatcher: Dispatcher {
    override val io: CoroutineDispatcher
        get() =  Dispatchers.IO
}

internal actual fun provideDispatcher(): Dispatcher = AndroidDispatcher()