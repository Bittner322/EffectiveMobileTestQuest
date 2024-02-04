package com.mikhail.effectivemobiletestquest.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mikhail.effectivemobiletestquest.presentation.screens.catalog.CatalogScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.favorites.FavoritesScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.product.ProductScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.profile.ProfileScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.sign_in.SignInScreen
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "catalog"
                ) {
                    composable(route = "sign_in") {
                        SignInScreen(navController = navController)
                    }
                    composable(route = "catalog") {
                        CatalogScreen(navController = navController)
                    }
                    composable(route = "product") {
                        ProductScreen(navController = navController)
                    }
                    composable(route = "profile") {
                        ProfileScreen(navController = navController)
                    }
                    composable(route = "favorites") {
                        FavoritesScreen(navController = navController)
                    }
                }
            }
        }
    }
}