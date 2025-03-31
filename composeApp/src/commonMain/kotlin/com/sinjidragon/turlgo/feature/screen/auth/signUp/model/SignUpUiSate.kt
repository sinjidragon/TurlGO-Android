package com.sinjidragon.turlgo.feature.screen.auth.signUp.model


data class SignUpUiSate(
    val signUpPendingUiState: SignUpPendingUiState = SignUpPendingUiState.Loading,
)

sealed interface SignUpPendingUiState {
    data object Success : SignUpPendingUiState
    data object Loading : SignUpPendingUiState
    data class Error(
        val idError: String?,
    ) : SignUpPendingUiState
}