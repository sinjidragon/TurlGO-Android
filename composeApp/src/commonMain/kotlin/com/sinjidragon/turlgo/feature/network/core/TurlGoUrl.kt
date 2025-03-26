package com.sinjidragon.turlgo.feature.network.core

object TurlGoUrl {
    private const val BASE_URL = "https://api.turlgo.o-r.kr"

    const val AUTH = "$BASE_URL/auth"

    object Auth {
        const val LOGIN = "$AUTH/login"
        const val SIGNUP = "$AUTH/sign-up"
        const val REFRESH = "$AUTH/refresh"
    }
}