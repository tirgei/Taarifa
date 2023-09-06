package com.tirgei.taarifa.ui

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String) {
    object Home: Screen("home")

    object Details: Screen("details") {
        const val newsPostId = "newsPostId"
        val routeWithArgs = "$route/{$newsPostId}"
        val arguments = listOf(
            navArgument(newsPostId) { type = NavType.StringType }
        )
    }


}