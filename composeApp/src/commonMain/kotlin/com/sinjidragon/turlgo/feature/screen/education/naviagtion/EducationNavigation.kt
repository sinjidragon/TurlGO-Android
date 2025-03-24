package com.sinjidragon.turlgo.feature.screen.education.naviagtion

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.education.EducationScreen

const val EDUCATION_ROUTE = "education"

fun NavController.navigateToEducation() = this.navigate(EDUCATION_ROUTE)

fun NavGraphBuilder.educationScreen() {
    composable(
        route = EDUCATION_ROUTE,
    ) {
        EducationScreen()
    }
}