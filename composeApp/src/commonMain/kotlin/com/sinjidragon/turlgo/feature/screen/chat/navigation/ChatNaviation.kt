package com.sinjidragon.turlgo.feature.screen.chat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.chat.ChatScreen
import com.sinjidragon.turlgo.feature.screen.home.HomeScreen

const val CHAT_ROUTE = "chat"

fun NavController.navigateToChat() = this.navigate(CHAT_ROUTE)

fun NavGraphBuilder.chatScreen() {
    composable(
        route = CHAT_ROUTE,
    ) {
        ChatScreen()
    }
}