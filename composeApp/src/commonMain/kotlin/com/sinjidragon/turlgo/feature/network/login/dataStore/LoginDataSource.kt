package com.sinjidragon.turlgo.feature.network.login.dataStore

import com.sinjidragon.turlgo.feature.network.login.model.LoginResponse


interface LoginDataSource {
    suspend fun login(id: String, pw: String): LoginResponse
    fun clearToken()
}
