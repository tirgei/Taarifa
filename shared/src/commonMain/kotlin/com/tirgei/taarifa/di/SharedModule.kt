package com.tirgei.taarifa.di

import com.tirgei.taarifa.BuildKonfig
import com.tirgei.taarifa.core.provideDispatcher
import com.tirgei.taarifa.data.network.ApiService
import com.tirgei.taarifa.data.repositories.NewsRepository
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
fun sharedModule() = module {
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

    // Repositories
    single<INewsRepository> { NewsRepository(get(), get()) }

}