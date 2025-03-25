package com.sinjidragon.turlgo.feature.screen.main

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.sinjidragon.turlgo.feature.screen.education.naviagtion.educationScreen
import com.sinjidragon.turlgo.feature.screen.home.navigation.HOME_ROUTE
import com.sinjidragon.turlgo.feature.screen.home.navigation.homeScreen
import com.sinjidragon.turlgo.feature.screen.main.navigation.MainDestination
import com.sinjidragon.turlgo.feature.screen.pat.navigation.patScreen
import com.sinjidragon.turlgo.resource.color.AppColors
import com.sinjidragon.turlgo.resource.function.noRippleClickable
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

@Composable
fun MainScreen(navHostController: NavHostController) {
    val mainNavController = rememberNavController()

    Scaffold {
        NavHost(
            navController = mainNavController,
            startDestination = HOME_ROUTE,
            modifier = Modifier.padding(it)
        ) {
            homeScreen()
            patScreen()
            educationScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute by navController.currentBackStackEntryFlow
        .map { it.destination.route }
        .distinctUntilChanged()
        .collectAsState(initial = HOME_ROUTE)

    LaunchedEffect(currentRoute) {
        println(currentRoute)
    }

    val items = listOf(
        MainDestination.HOME,
        MainDestination.PAT,
        MainDestination.EDUCATION
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(73.dp)
            .padding(horizontal = 60.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEach { destination ->
            val isSelected = currentRoute == destination.route
            BottomCard(

                icon = destination.getIcon(),
                label = destination.label,
                isSelected = isSelected,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
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
    val color = if (isSelected) AppColors.main_color else AppColors.bottom_gray

    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1.0f,
        animationSpec = tween(durationMillis = 100),
        label = "scale"
    )

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .scale(scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        if (!isSelected){
                            onClick()
                        }
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
            colorFilter = ColorFilter.tint(color)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = label,
            color = color
        )
    }
}
