package com.example.tmdbtestapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tmdbtestapp.ui.details.MovieDetails
import com.example.tmdbtestapp.ui.main.MainScreen

@Composable
fun TmdbNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.route
    ) {
        composable(route = MainScreen.route) {
            MainScreen(paddingValues = paddingValues)
        }
        composable(route = DetailScreen.route) {
            MovieDetails()
        }
    }
}

private fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }