package com.sinjidragon.turlgo.feature.network.core.model

import kotlinx.serialization.Serializable

@Serializable
enum class NetworkStatus {
    ALLOWED,
    PENDING,
    REJECTED,
}
