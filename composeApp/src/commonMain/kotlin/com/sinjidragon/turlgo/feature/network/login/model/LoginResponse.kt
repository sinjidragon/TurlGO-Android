package com.sinjidragon.turlgo.feature.network.login.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("accessToken") val accessToken: String?,
    @SerialName("refreshToken") val refreshToken: String?,
    @SerialName("tokenType") val tokenType: String?
)
