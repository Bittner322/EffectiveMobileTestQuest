package com.mikhail.effectivemobiletestquest.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mikhail.effectivemobiletestquest.presentation.screens.catalog.CatalogScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.sign_in.SignInScreen
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectiveTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "sign_in"
                ) {
                    composable(route = "sign_in") {
                        SignInScreen(navController = navController)
                    }
                    composable(route = "catalog") {
                        CatalogScreen(navController = navController)
                    }
                }
            }
        }
    }
}