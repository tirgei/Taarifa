package com.tirgei.taarifa.data.network

import com.tirgei.taarifa.data.network.responses.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * Class to handle all http requests
 */
class ApiService(
    private val httpClient: HttpClient
) {

    suspend fun fetchTopNews(): NewsResponse
        = httpClient.get("v2/top-headlines").body()

}