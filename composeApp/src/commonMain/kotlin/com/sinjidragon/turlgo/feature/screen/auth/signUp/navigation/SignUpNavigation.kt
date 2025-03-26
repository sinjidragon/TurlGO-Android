package com.sinjidragon.turlgo.feature.screen.auth.signUp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.auth.signUp.SignUpScreen

const val SIGNUP_ROUTE = "signup"

fun NavController.navigateToSignUp() = this.navigate(SIGNUP_ROUTE)

fun NavGraphBuilder.signUpScreen(
    navigateToLogin: () -> Unit,
    popBackStack: () -> Unit
) {
    composable(
        route = SIGNUP_ROUTE,
    ) {
        SignUpScreen(
            navigateToLogin = navigateToLogin,
            popBackStack = popBackStack
        )
    }
}