package com.sinjidragon.turlgo.feature.screen.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.home.HomeScreen

const val HOME_ROUTE = "home"

fun NavController.navigateToHome() = this.navigate(HOME_ROUTE)

fun NavGraphBuilder.homeScreen() {
    composable(
        route = HOME_ROUTE,
    ) {
        HomeScreen()
    }
}
