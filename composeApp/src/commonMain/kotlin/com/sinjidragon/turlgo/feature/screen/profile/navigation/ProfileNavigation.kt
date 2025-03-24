package com.sinjidragon.turlgo.feature.screen.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.profile.ProfileScreen

const val PROFILE_ROUTE = "profile"

fun NavController.navigateToProfile() = this.navigate(PROFILE_ROUTE)

fun NavGraphBuilder.profileScreen() {
    composable(
        route = PROFILE_ROUTE,
    ) {
        ProfileScreen()
    }
}