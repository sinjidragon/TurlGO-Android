package com.sinjidragon.turlgo.feature.screen.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.sinjidragon.turlgo.feature.screen.article.navigation.ARTICLE_ROUTE
import com.sinjidragon.turlgo.feature.screen.chat.navigation.CHAT_ROUTE
import com.sinjidragon.turlgo.feature.screen.home.navigation.HOME_ROUTE
import com.sinjidragon.turlgo.feature.screen.profile.navigation.PROFILE_ROUTE
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import turlgo.composeapp.generated.resources.Res
import turlgo.composeapp.generated.resources.book_opened
import turlgo.composeapp.generated.resources.home_alt
import turlgo.composeapp.generated.resources.person
import turlgo.composeapp.generated.resources.vector

enum class MainDestination(
    val iconRes: DrawableResource,
    val route: String,
) {
    HOME(Res.drawable.home_alt, HOME_ROUTE),
    ARTICLE(Res.drawable.book_opened, ARTICLE_ROUTE),
    CHAT(Res.drawable.vector, CHAT_ROUTE),
    PROFILE(Res.drawable.person, PROFILE_ROUTE);

    @Composable
    fun getIcon(): Painter {
        return painterResource(iconRes)
    }
}