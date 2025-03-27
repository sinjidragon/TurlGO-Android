package com.sinjidragon.turlgo.feature.network.core.model

import kotlinx.serialization.Serializable

@Serializable
internal data class TokenResponse(
    val accessToken: String?,
    val refreshToken: String?,
    val tokenType: String?
)
