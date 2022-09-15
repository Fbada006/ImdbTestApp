package com.example.tmdbtestapp.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface TmdbDestinations {
    val route: String
}

object MainScreen : TmdbDestinations {
    override val route = "com.example.tmdbtestapp.mainscreen"
}

object DetailScreen : TmdbDestinations {
    override val route = "com.example.tmdbtestapp.detailscreen"
    const val movieJsonArg = "movieJson"
    val routeWithArgs = "${route}/{${movieJsonArg}}"
    val arguments = listOf(
        navArgument(movieJsonArg) { type = NavType.LongType }
    )
}

// These are destinations that should have a back button
val popDestinations = listOf(
    DetailScreen.route
)
