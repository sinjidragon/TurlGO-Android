package com.sinjidragon.turlgo.feature.screen.first.naviagtion

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.first.FirstScreen

const val FIRST_ROUTE = "first"

fun NavController.navigateToFirst() = this.navigate(FIRST_ROUTE)

fun NavGraphBuilder.firstScreen(
    navigateToLogin: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    composable(
        route = FIRST_ROUTE,
    ) {
        FirstScreen(
            navigateToLogin = navigateToLogin,
            navigateToSignUp = navigateToSignUp
        )
    }
}