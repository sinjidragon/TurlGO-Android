package com.sinjidragon.turlgo.feature.screen.auth.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.auth.login.LoginScreen

const val LOGIN_ROUTE = "login"

fun NavController.navigateToLogin() = this.navigate(LOGIN_ROUTE)

fun NavGraphBuilder.loginScreen(
    navigateToSignUp: () -> Unit,
    popBackStack: () -> Unit
) {
    composable(
        route = LOGIN_ROUTE,
    ) {
        LoginScreen(
            navigateToSignUp = navigateToSignUp,
            popBackStack = popBackStack
        )
    }
}