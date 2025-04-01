package com.sinjidragon.turlgo.feature.network.signup.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    @SerialName("username") val username: String,
    @SerialName("password") val password: String,
    @SerialName("email") val email: String,
)
