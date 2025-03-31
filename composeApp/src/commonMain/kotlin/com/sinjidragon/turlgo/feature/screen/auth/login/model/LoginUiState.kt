package com.sinjidragon.turlgo.feature.screen.auth.login.model

import com.sinjidragon.turlgo.feature.data.login.model.Token

data class LoginUiState(
    val loginUiState: LoginPendingUiState = LoginPendingUiState.Loading,
    val token: Token = Token("초기값", "초기값", "초기값")
)

sealed interface LoginPendingUiState {
    data class Success(
        val token: Token,
    ) : LoginPendingUiState
    data object Loading : LoginPendingUiState
    data class Error(
        val error: String?
    ) : LoginPendingUiState
}
