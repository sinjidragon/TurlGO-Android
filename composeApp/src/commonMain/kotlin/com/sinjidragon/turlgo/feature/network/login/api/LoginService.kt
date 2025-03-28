package com.sinjidragon.turlgo.feature.network.login.api

import com.sinjidragon.turlgo.feature.network.login.model.LoginRequest
import com.sinjidragon.turlgo.feature.network.login.model.LoginResponse
import com.sinjidragon.turlgo.feature.network.core.TurlGoUrl
import com.sinjidragon.turlgo.feature.network.core.model.Response
import com.sinjidragon.turlgo.feature.network.core.util.safeRequest
import com.sinjidragon.turlgo.feature.network.login.dataStore.LoginDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

internal class LoginService(
    private val client: HttpClient,
) : LoginDataSource {
    override suspend fun login(id: String, pw: String): LoginResponse {
        return safeRequest {
            val response = client.post(TurlGoUrl.Auth.LOGIN) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                setBody(LoginRequest(id, pw))
            }

            println("=== Login Request Debug ===")
            println("URL: ${TurlGoUrl.Auth.LOGIN}")
            println("Request Body: ${LoginRequest(id, pw)}")
            println("Response Status: ${response.status}")
            println("Response Headers: ${response.headers.entries()}")

            try {
                val responseBody = response.bodyAsText()
                println("Response Body: $responseBody")
            } catch (e: Exception) {
                println("Could not read response body: ${e.message}")
            }

            response.body<Response<LoginResponse>>()
        }
    }
    override fun clearToken() {
//        client.clearToken()
    }
}