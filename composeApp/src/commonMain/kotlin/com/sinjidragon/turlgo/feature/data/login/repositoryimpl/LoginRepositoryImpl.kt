package com.sinjidragon.turlgo.feature.data.login.repositoryimpl

import com.sinjidragon.turlgo.feature.data.login.model.Token
import com.sinjidragon.turlgo.feature.data.login.model.toModel
import com.sinjidragon.turlgo.feature.data.login.repository.LoginRepository
import com.sinjidragon.turlgo.feature.network.core.Dispatcher
import com.sinjidragon.turlgo.feature.network.core.DispatcherType
import com.sinjidragon.turlgo.feature.network.core.model.Response
import com.sinjidragon.turlgo.feature.network.login.dataStore.LoginDataSource
import kotlinx.coroutines.CoroutineDispatcher
import com.sinjidragon.turlgo.feature.network.core.result.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.sinjidragon.turlgo.feature.network.core.result.Result

internal class LoginRepositoryImpl(
    private val loginDataSource: LoginDataSource,
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher,
) : LoginRepository {

    override fun login(id: String, pw: String): Flow<Result<Token?>> {
        return flow {
            emit(
                loginDataSource.login(id, pw).toModel(),
            )
            loginDataSource.clearToken()
        }
            .asResult()
            .flowOn(dispatcher)
    }

    override fun clearToken() {
        loginDataSource.clearToken()
    }
}
