package com.sinjidragon.turlgo.feature.network.signup.api

import com.sinjidragon.turlgo.feature.network.core.TurlGoUrl
import com.sinjidragon.turlgo.feature.network.core.model.DefaultResponse
import com.sinjidragon.turlgo.feature.network.core.model.Response
import com.sinjidragon.turlgo.feature.network.core.util.defaultSafeRequest
import com.sinjidragon.turlgo.feature.network.login.model.LoginRequest
import com.sinjidragon.turlgo.feature.network.login.model.LoginResponse
import com.sinjidragon.turlgo.feature.network.signup.dataSource.SignUpDataSource
import com.sinjidragon.turlgo.feature.network.signup.model.SignUpRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal class SignUpService(
    private val client: HttpClient,
) : SignUpDataSource {
    override suspend fun signUp(id: String, pw: String, email: String) {
        return defaultSafeRequest {
            val response = client.post(TurlGoUrl.Auth.SIGNUP) {
                contentType(ContentType.Application.Json)
                setBody(
                    SignUpRequest(
                        username = id,
                        password = pw,
                        email = email
                    )
                )
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

            response.body<DefaultResponse>()
        }
    }
}
