package com.example.tmdbtestapp.navigation

interface TmdbDestinations {
    val route: String
}

object MainScreen : TmdbDestinations {
    override val route = "com.example.tmdbtestapp.mainscreen"
}

object DetailScreen : TmdbDestinations {
    override val route = "com.example.tmdbtestapp.detailscreen"
}
