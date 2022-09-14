package com.example.tmdbtestapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.res.stringResource
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

                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = stringResource(id = R.string.app_name)) }
                        )
                    }
                ) { paddingValues ->
                    TmdbNavHost(navController = navController, paddingValues = paddingValues)
                }
            }
        }
    }
}
