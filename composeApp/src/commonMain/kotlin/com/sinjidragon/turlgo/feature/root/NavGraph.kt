package com.sinjidragon.turlgo.feature.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.article.ArticleScreen
import com.sinjidragon.turlgo.feature.screen.chat.ChatScreen
import com.sinjidragon.turlgo.feature.screen.home.HomeScreen
import com.sinjidragon.turlgo.feature.screen.profile.ProfileScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavGroup.HOME) {
        composable(NavGroup.HOME) { HomeScreen() }
        composable(NavGroup.ARTICLE) { ArticleScreen() }
        composable(NavGroup.CHAT) { ChatScreen() }
        composable(NavGroup.PROFILE) { ProfileScreen() }
    }
}
