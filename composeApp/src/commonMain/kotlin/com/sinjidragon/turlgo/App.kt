package com.sinjidragon.turlgo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sinjidragon.turlgo.feature.screen.auth.login.navigation.loginScreen
import com.sinjidragon.turlgo.feature.screen.auth.login.navigation.navigateToLogin
import com.sinjidragon.turlgo.feature.screen.auth.signUp.navigation.navigateToSignUp
import com.sinjidragon.turlgo.feature.screen.auth.signUp.navigation.signUpScreen
import com.sinjidragon.turlgo.feature.screen.first.naviagtion.FIRST_ROUTE
import com.sinjidragon.turlgo.feature.screen.education.naviagtion.educationScreen
import com.sinjidragon.turlgo.feature.screen.first.naviagtion.firstScreen
import com.sinjidragon.turlgo.feature.screen.home.navigation.HOME_ROUTE
import com.sinjidragon.turlgo.feature.screen.home.navigation.homeScreen
import com.sinjidragon.turlgo.feature.screen.main.BottomNavigationBar
import com.sinjidragon.turlgo.feature.screen.main.navigation.MAIN_ROUTE
import com.sinjidragon.turlgo.feature.screen.main.navigation.mainScreen
import com.sinjidragon.turlgo.feature.screen.my.navigation.myScreen
import com.sinjidragon.turlgo.feature.screen.pat.navigation.PAT_ROUTE
import com.sinjidragon.turlgo.feature.screen.pat.navigation.patScreen
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

@Composable
@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
fun App(
    navHostController: NavHostController = rememberNavController(),
) {
    val currentRoute by navHostController.currentBackStackEntryFlow
        .map { it.destination.route }
        .distinctUntilChanged()
        .collectAsState(initial = HOME_ROUTE)
    Scaffold(
        bottomBar = {
            if (currentRoute == "home" || currentRoute == "education" || currentRoute == "pat" || currentRoute == "my") {
                BottomNavigationBar(navController = navHostController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = FIRST_ROUTE,
            modifier = Modifier.padding(innerPadding)
        ) {
            mainScreen(
                navHostController = navHostController,
            )
            homeScreen()
            educationScreen()
            patScreen()
            firstScreen(
                navigateToLogin = navHostController::navigateToLogin,
                navigateToSignUp = navHostController::navigateToSignUp
            )
            loginScreen(
                navigateToSignUp = navHostController::navigateToSignUp,
                popBackStack = navHostController::popBackStack
            )
            signUpScreen(
                navigateToLogin = navHostController::navigateToLogin,
                popBackStack = navHostController::popBackStack
            )
        }
    }
}
