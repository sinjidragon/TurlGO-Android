package com.sinjidragon.turlgo.feature.data.login.repository

import com.sinjidragon.turlgo.feature.data.login.model.Token
import com.sinjidragon.turlgo.feature.network.core.model.Response
import com.sinjidragon.turlgo.feature.network.core.result.Result
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(id: String, pw: String): Flow<Result<Token?>>
    fun clearToken()
}
