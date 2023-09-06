package com.tirgei.taarifa

import com.tirgei.taarifa.data.repositories.NewsRepository
import com.tirgei.taarifa.domain.respositories.INewsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/**
 * Used to locate dependencies that are required by iOS Native classes
 * e.g Swift ViewModel
 *
 * An example is when we need to use [NewsRepository] from the native iOS ViewModel
 */
object DIHelper: KoinComponent {
    fun getNewsRepository(): INewsRepository = get()
}