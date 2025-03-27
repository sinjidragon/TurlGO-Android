package com.sinjidragon.turlgo.feature.network.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    @SerialName("status") val status: Int,
    @SerialName("state") val state: String,
    @SerialName("message") val message: String,
    @SerialName("data") val data: T? = null,
)


