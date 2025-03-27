package com.sinjidragon.turlgo.feature.screen.auth.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinjidragon.turlgo.feature.data.login.repository.LoginRepository
import com.sinjidragon.turlgo.feature.network.core.TurlGoUrl
import com.sinjidragon.turlgo.feature.screen.auth.login.model.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.sinjidragon.turlgo.feature.network.core.result.Result
import com.sinjidragon.turlgo.feature.screen.auth.login.model.LoginPendingUiState
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel(), KoinComponent {
    private val loginRepository: LoginRepository by inject()

    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    fun login(id: String, password: String) {
        viewModelScope.launch {
            loginRepository.login(id = id, pw = password).collect { result ->
                when (result) {
                    is Result.Error -> {
                        result.error.printStackTrace()
                        _state.update {
                            it.copy(
                                loginUiState = LoginPendingUiState.Error
                            )
                        }
                        println(result)
                        return@collect
                    }

                    Result.Loading -> {
                        println("퍼킹 로딩")
                    }

                    is Result.Success -> {
                        println("퍼킹 성공!!!")
                        val token = result.data
                        println(token)
                        _state.update { currentState ->
                            if (token != null) {
                                currentState.copy(
                                    token = token
                                )
                            } else {
                                currentState
                            }
                        }

                        return@collect
                    }
                }
            }
        }
    }

    fun getErrorStatus(th: Throwable): Int = when (th) {
        is RedirectResponseException -> { //Http Code: 3xx
            (th.response.status.value)
        }
        is ClientRequestException -> { //Http Code: 4xx
            (th.response.status.value)
        }
        is ServerResponseException -> { //Http Code: 5xx
            (th.response.status.value)
        }
        is UnresolvedAddressException -> { // Network Error - Internet Error
            1000
        }
        else -> 9999 // Unknown
    }
}