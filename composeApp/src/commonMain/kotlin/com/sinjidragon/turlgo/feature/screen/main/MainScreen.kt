package com.sinjidragon.turlgo.feature.screen.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sinjidragon.turlgo.feature.screen.home.navigation.HOME_ROUTE
import com.sinjidragon.turlgo.feature.screen.home.navigation.homeScreen
import com.sinjidragon.turlgo.feature.screen.main.navigation.MainDestination
import com.sinjidragon.turlgo.feature.screen.my.navigation.myScreen
import com.sinjidragon.turlgo.feature.screen.pat.navigation.patScreen
import com.sinjidragon.turlgo.resource.color.AppColors
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.sinjidragon.turlgo.feature.screen.education.naviagtion.educationScreen

@Composable
fun MainScreen(navHostController: NavHostController) {
    val mainNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(mainNavController) }
    ) { paddingValues ->
        NavHost(
            navController = mainNavController,
            startDestination = HOME_ROUTE,
            modifier = Modifier.padding(paddingValues)
        ) {
            homeScreen()
            patScreen()
            educationScreen()
            myScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: HOME_ROUTE

    val items = listOf(
        MainDestination.HOME,
        MainDestination.PAT,
        MainDestination.EDUCATION,
        MainDestination.MY
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(73.dp)
            .padding(horizontal = 60.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEach { destination ->
            BottomCard(
                icon = destination.getIcon(),
                label = destination.label,
                isSelected = destination.route == currentRoute,
                onClick = {
                    navController.navigate(destination.route) {
                        // 기존 스택에서 같은 경로의 모든 인스턴스 팝
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // 동일한 경로를 다시 선택해도 재생성되지 않도록
                        launchSingleTop = true
                        // 이전 상태 복원
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun BottomCard(
    isSelected: Boolean,
    icon: Painter,
    label: String = "",
    onClick: () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }

    val animatedColor by animateColorAsState(
        animationSpec = tween(
            durationMillis = 200,
            delayMillis = 100,
        ),
        targetValue = if (isSelected) AppColors.main_color else AppColors.bottom_gray
    )

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.60f else 1.0f,
        animationSpec = tween(durationMillis = 250),
        label = "scale"
    )

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .scale(scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        onClick()
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            }
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            colorFilter = ColorFilter.tint(animatedColor)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = label,
            color = animatedColor
        )
    }
}