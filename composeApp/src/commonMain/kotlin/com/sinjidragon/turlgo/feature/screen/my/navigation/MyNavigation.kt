package com.sinjidragon.turlgo.feature.screen.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.my.MyScreen

const val MY_ROUTE = "my"

fun NavController.navigateToMy() = this.navigate(MY_ROUTE)

fun NavGraphBuilder.myScreen() {
    composable(
        route = MY_ROUTE,
    ) {
        MyScreen()
    }
}