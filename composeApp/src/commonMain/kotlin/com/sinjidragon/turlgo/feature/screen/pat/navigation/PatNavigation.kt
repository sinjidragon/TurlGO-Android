package com.sinjidragon.turlgo.feature.screen.pat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.education.EducationScreen
import com.sinjidragon.turlgo.feature.screen.pat.PatScreen

const val PAT_ROUTE = "pat"

fun NavController.navigateToPat() = this.navigate(PAT_ROUTE)

fun NavGraphBuilder.patScreen() {
    composable(
        route = PAT_ROUTE,
    ) {
        PatScreen()
    }
}