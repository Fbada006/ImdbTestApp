package com.example.tmdbtestapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tmdbtestapp.ui.TmdbViewmodel
import com.example.tmdbtestapp.ui.details.MovieDetails
import com.example.tmdbtestapp.ui.main.MainScreen

@Composable
fun TmdbNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
    tmdbViewmodel: TmdbViewmodel
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.route
    ) {
        composable(route = MainScreen.route) {
            MainScreen(paddingValues = paddingValues, tmdbViewmodel = tmdbViewmodel, onMovieClick = { movie ->
                navController.navigateToDetailScreen(movie.id)
            })
        }
        composable(
            route = DetailScreen.routeWithArgs,
            arguments = DetailScreen.arguments
        ) { navBackStackEntry ->
            val movieId =
                navBackStackEntry.arguments?.getLong(DetailScreen.movieJsonArg)
            MovieDetails(
                movieId = movieId, tmdbViewmodel = tmdbViewmodel, modifier = Modifier
                    .wrapContentHeight()
                    .padding(all = 4.dp)
            )
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

fun NavHostController.navigateToDetailScreen(movieId: Long) {
    this.navigateSingleTopTo("${DetailScreen.route}/$movieId")
}