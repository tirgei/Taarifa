package com.tirgei.taarifa.data.network

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tirgei.taarifa.data.network.responses.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/**
 * Class to handle all http requests
 */
class ApiService(
    private val httpClient: HttpClient
) {

    @NativeCoroutines
    suspend fun fetchTopNews(): NewsResponse = httpClient.get("/v2/top-headlines"){
            parameter("country", "US")
    }.body()

}