package com.example.tmdbtestapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.tmdbtestapp.R
import com.example.tmdbtestapp.navigation.TmdbNavHost
import com.example.tmdbtestapp.ui.theme.TmdbTestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TmdbTestAppTheme {
                val navController = rememberNavController()
                val tmdbViewmodel: TmdbViewmodel = hiltViewModel()
                val canPop by tmdbViewmodel.canPopState.collectAsState()

                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        if (canPop) {
                            TopAppBar(
                                title = { Text(text = stringResource(id = R.string.title_movie_details)) },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        navController.navigateUp()
                                    }) {
                                        Icon(Icons.Rounded.ArrowBack, stringResource(id = R.string.cd_back_button))
                                    }
                                }
                            )
                        } else {
                            TopAppBar(
                                title = { Text(text = stringResource(id = R.string.app_name)) }
                            )
                        }
                    }
                ) { paddingValues ->
                    TmdbNavHost(navController = navController, paddingValues = paddingValues, tmdbViewmodel = tmdbViewmodel)
                }
            }
        }
    }
}
