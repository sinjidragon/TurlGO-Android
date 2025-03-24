package com.sinjidragon.turlgo.feature.screen.article.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinjidragon.turlgo.feature.screen.article.ArticleScreen

const val ARTICLE_ROUTE = "article"

fun NavController.navigateToArticle() = this.navigate(ARTICLE_ROUTE)

fun NavGraphBuilder.articleScreen() {
    composable(
        route = ARTICLE_ROUTE,
    ) {
        ArticleScreen()
    }
}