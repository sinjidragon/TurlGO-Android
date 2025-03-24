package com.sinjidragon.turlgo.feature.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sinjidragon.turlgo.feature.screen.article.navigation.articleScreen
import com.sinjidragon.turlgo.feature.screen.chat.navigation.chatScreen
import com.sinjidragon.turlgo.feature.screen.home.navigation.HOME_ROUTE
import com.sinjidragon.turlgo.feature.screen.home.navigation.homeScreen
import com.sinjidragon.turlgo.feature.screen.main.navigation.MainDestination
import com.sinjidragon.turlgo.feature.screen.profile.navigation.profileScreen
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
            articleScreen()
            profileScreen()
            chatScreen()
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
        MainDestination.ARTICLE,
        MainDestination.CHAT,
        MainDestination.PROFILE
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(73.dp)
            .padding(horizontal = 46.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEach { destination ->
            val isSelected = currentRoute == destination.route
            BottomCard(
                icon = destination.getIcon(),
                text = destination.route,
                textColor = if (isSelected) Color.Black else Color.Gray,
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
    icon: Painter,
    text: String,
    textColor: Color = Color.Gray,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            color = textColor,
        )
    }
}
