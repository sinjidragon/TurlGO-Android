package com.sinjidragon.turlgo.feature.network.signup.dataSource

interface SignUpDataSource {
    suspend fun signUp(id: String, pw: String, email: String)
}
