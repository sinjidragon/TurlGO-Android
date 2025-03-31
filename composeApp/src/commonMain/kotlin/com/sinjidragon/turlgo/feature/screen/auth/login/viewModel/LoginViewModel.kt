package com.sinjidragon.turlgo.feature.screen.auth.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinjidragon.turlgo.feature.data.login.repository.LoginRepository
import com.sinjidragon.turlgo.feature.network.core.result.Result
import com.sinjidragon.turlgo.feature.screen.auth.login.model.LoginPendingUiState
import com.sinjidragon.turlgo.feature.screen.auth.login.model.LoginUiState
import com.sinjidragon.turlgo.feature.screen.auth.signUp.model.SignUpPendingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

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
                                loginUiState = LoginPendingUiState.Error(result.error.message)
                            )
                        }
                        println(result)
                        return@collect
                    }

                    Result.Loading -> {
                    }

                    is Result.Success -> {
                        val token = result.data
                        _state.update { currentState ->
                            token?.let {
                                currentState.copy(
                                    token = it,
                                    loginUiState = LoginPendingUiState.Success(it)
                                )
                            } ?: currentState
                        }

                        return@collect
                    }
                }
            }
        }
    }
}