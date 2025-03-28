package com.sinjidragon.turlgo.feature.data.login.model

import com.sinjidragon.turlgo.feature.network.login.model.LoginResponse


data class Token(
    val accessToken: String?,
    val refreshToken: String?,
    val tokenType: String?
)

internal fun LoginResponse.toModel(): Token?= refreshToken?.let {
    Token(
        accessToken = accessToken,
        refreshToken = it,
        tokenType = tokenType
    )
}
