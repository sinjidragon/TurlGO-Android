package com.sinjidragon.turlgo.feature.screen.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.sinjidragon.turlgo.feature.screen.education.naviagtion.EDUCATION_ROUTE
import com.sinjidragon.turlgo.feature.screen.home.navigation.HOME_ROUTE
import com.sinjidragon.turlgo.feature.screen.my.navigation.MY_ROUTE
import com.sinjidragon.turlgo.feature.screen.pat.navigation.PAT_ROUTE
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import turlgo.composeapp.generated.resources.Res
import turlgo.composeapp.generated.resources.edu_icon
import turlgo.composeapp.generated.resources.home_icon
import turlgo.composeapp.generated.resources.my_icon
import turlgo.composeapp.generated.resources.pat_icon

enum class MainDestination(
    val iconRes: DrawableResource,
    val route: String,
    val label: String
) {
    HOME(Res.drawable.home_icon, HOME_ROUTE, "홈"),
    PAT(Res.drawable.pat_icon, PAT_ROUTE, "유기견") ,
    EDUCATION(Res.drawable.edu_icon, EDUCATION_ROUTE, "교육"),
    MY(Res.drawable.my_icon,MY_ROUTE, "마이");


    @Composable
    fun getIcon(): Painter {
        return painterResource(iconRes)
    }
}