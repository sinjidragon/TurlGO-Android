package com.sinjidragon.turlgo.feature.screen.auth.signUp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinjidragon.turlgo.feature.data.login.repository.LoginRepository
import com.sinjidragon.turlgo.feature.data.signUp.repository.SignUpRepository
import com.sinjidragon.turlgo.feature.network.core.result.Result
import com.sinjidragon.turlgo.feature.screen.auth.login.model.LoginPendingUiState
import com.sinjidragon.turlgo.feature.screen.auth.login.model.LoginUiState
import com.sinjidragon.turlgo.feature.screen.auth.signUp.model.SignUpPendingUiState
import com.sinjidragon.turlgo.feature.screen.auth.signUp.model.SignUpUiSate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignUpViewModel : ViewModel(), KoinComponent {
    private val loginRepository: SignUpRepository by inject()

    private val _state = MutableStateFlow(SignUpUiSate())
    val state = _state.asStateFlow()

    fun signUp(username: String, password: String, email: String) {
        println("회원가입 뷰모델 호출됨")
        viewModelScope.launch {
            loginRepository.signUp(username = username, password = password, email = email).collect { result ->
                when (result) {
                    is Result.Error -> {
                        result.error.printStackTrace()
                        _state.update {
                            it.copy(
                                signUpPendingUiState = SignUpPendingUiState.Error(result.error.message)
                            )
                        }
                        println(result)
                        return@collect
                    }

                    Result.Loading -> {
                    }

                    is Result.Success -> {
                        _state.update {
                            it.copy(
                                signUpPendingUiState = SignUpPendingUiState.Success
                            )
                        }

                        return@collect
                    }
                }
            }
        }
    }
}