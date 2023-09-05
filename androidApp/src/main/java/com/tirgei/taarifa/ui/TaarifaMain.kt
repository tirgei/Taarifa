package com.tirgei.taarifa.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tirgei.taarifa.ui.details.DetailsScreen
import com.tirgei.taarifa.ui.home.HomeScreen

@Composable
fun TaarifaMain() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        
        composable(route = Screen.Details.route) {
            DetailsScreen(navController = navController)
        }
    }
}