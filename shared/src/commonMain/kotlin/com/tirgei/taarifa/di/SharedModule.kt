package com.tirgei.taarifa.di

import com.tirgei.taarifa.BuildKonfig
import com.tirgei.taarifa.core.DatabaseDriverFactory
import com.tirgei.taarifa.core.provideDispatcher
import com.tirgei.taarifa.data.local.NewsCache
import com.tirgei.taarifa.data.network.ApiService
import com.tirgei.taarifa.data.repositories.NewsRepository
import com.tirgei.taarifa.database.TaarifaDatabase
import com.tirgei.taarifa.domain.respositories.INewsRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

/**
 * Modules used by both platforms
 */
val sharedModule = module {
    // Dispatcher
    factory { provideDispatcher() }

    // Network
    single {
        HttpClient() {
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = BuildKonfig.BASE_URL
                    parameters.append("apiKey", BuildKonfig.API_KEY)
                }
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
        }
    }
    single { ApiService(get()) }

    // Local cache
    single { TaarifaDatabase(get<DatabaseDriverFactory>().create()) }
    single { NewsCache(get(), get()) }

    // Repositories
    single<INewsRepository> { NewsRepository(get(), get(), get()) }

}

/**
 * Modules that are setup in the shared module. Includes both shared modules
 * plus platform modules which is made up of modules with individual
 * implementations for both platforms
 */
fun getBaseModules() = sharedModule + platformModule