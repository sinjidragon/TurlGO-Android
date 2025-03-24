package com.sinjidragon.turlgo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sinjidragon.turlgo.feature.screen.education.naviagtion.educationScreen
import com.sinjidragon.turlgo.feature.screen.home.navigation.HOME_ROUTE
import com.sinjidragon.turlgo.feature.screen.home.navigation.homeScreen
import com.sinjidragon.turlgo.feature.screen.main.BottomNavigationBar
import com.sinjidragon.turlgo.feature.screen.main.navigation.mainScreen
import com.sinjidragon.turlgo.feature.screen.pat.navigation.patScreen

@Composable
@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
fun App(
    navHostController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navHostController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = HOME_ROUTE,
            modifier = Modifier.padding(innerPadding)
        ) {
            mainScreen(
                navHostController = navHostController,
            )
            homeScreen()
            educationScreen()
            patScreen()
        }
    }
}
