package com.sinjidragon.turlgo.feature.screen.main.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.sinjidragon.turlgo.feature.screen.main.MainScreen

const val MAIN_ROUTE = "main"

fun NavController.navigateToMain(
    navOptions: NavOptions? = navOptions {
        launchSingleTop = true
    },
) = navigate(MAIN_ROUTE, navOptions)

@ExperimentalMaterialApi
@ExperimentalFoundationApi
fun NavGraphBuilder.mainScreen(
    navHostController: NavHostController
) {
    composable(route = MAIN_ROUTE) {
        MainScreen(
            navHostController = navHostController
        )
    }
}
