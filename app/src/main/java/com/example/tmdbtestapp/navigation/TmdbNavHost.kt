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
import androidx.paging.PagingData
import com.example.tmdbtestapp.models.Movie
import com.example.tmdbtestapp.ui.details.MovieDetails
import com.example.tmdbtestapp.ui.main.MainScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun TmdbNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
    detailsMovie: StateFlow<Movie?>,
    setPopState: (route: String) -> Unit,
    movies: Flow<PagingData<Movie>>,
    getMovieById: (movieId: Long?) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.route
    ) {
        composable(route = MainScreen.route) {
            MainScreen(movies = movies, paddingValues = paddingValues, setPopState = setPopState, onMovieClick = { movie ->
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
                movieId = movieId, modifier = Modifier
                    .wrapContentHeight()
                    .padding(all = 4.dp),
                movieState = detailsMovie,
                setPopState = setPopState,
                getMovieById = getMovieById
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