package com.sinjidragon.turlgo.feature.data.signUp.repository

import kotlinx.coroutines.flow.Flow
import com.sinjidragon.turlgo.feature.network.core.result.Result

interface SignUpRepository {
    fun signUp(username: String, password: String, email: String): Flow<Result<Unit>>
}