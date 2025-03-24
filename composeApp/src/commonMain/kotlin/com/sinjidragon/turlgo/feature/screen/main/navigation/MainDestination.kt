package com.sinjidragon.turlgo.feature.screen.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.sinjidragon.turlgo.feature.screen.education.naviagtion.EDUCATION_ROUTE
import com.sinjidragon.turlgo.feature.screen.home.navigation.HOME_ROUTE
import com.sinjidragon.turlgo.feature.screen.pat.navigation.PAT_ROUTE
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import turlgo.composeapp.generated.resources.Res
import turlgo.composeapp.generated.resources.education
import turlgo.composeapp.generated.resources.education_selected
import turlgo.composeapp.generated.resources.footprint
import turlgo.composeapp.generated.resources.footprint_selected
import turlgo.composeapp.generated.resources.home
import turlgo.composeapp.generated.resources.home_selected

enum class MainDestination(
    val iconRes: DrawableResource,
    val iconSelectedRes: DrawableResource,
    val route: String,
) {
    HOME(Res.drawable.home,Res.drawable.home_selected, HOME_ROUTE),
    PAT(Res.drawable.footprint, Res.drawable.footprint_selected, PAT_ROUTE),
    EDUCATION(Res.drawable.education, Res.drawable.education_selected, EDUCATION_ROUTE);


    @Composable
    fun getIcon(): Painter {
        return painterResource(iconRes)
    }

    @Composable
    fun getSelectedIcon(): Painter {
        return painterResource(iconSelectedRes)
    }
}