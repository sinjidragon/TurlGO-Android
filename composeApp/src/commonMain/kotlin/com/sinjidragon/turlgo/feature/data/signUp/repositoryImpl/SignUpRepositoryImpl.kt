package com.sinjidragon.turlgo.feature.data.signUp.repositoryImpl

import com.sinjidragon.turlgo.feature.data.signUp.repository.SignUpRepository
import com.sinjidragon.turlgo.feature.network.core.Dispatcher
import com.sinjidragon.turlgo.feature.network.core.DispatcherType
import com.sinjidragon.turlgo.feature.network.core.result.Result
import com.sinjidragon.turlgo.feature.network.core.result.asResult
import com.sinjidragon.turlgo.feature.network.signup.dataSource.SignUpDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class SignUpRepositoryImpl(
    private val signUpDataSource: SignUpDataSource,
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher,
) : SignUpRepository {

    override fun signUp(username: String, password: String, email: String): Flow<Result<Unit>> {
        return flow {
            emit(
                signUpDataSource.signUp(
                    id = username,
                    pw = password,
                    email = email
                )
            )
        }.asResult().flowOn(dispatcher)
    }
}
