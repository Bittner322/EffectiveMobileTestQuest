package com.mikhail.effectivemobiletestquest.presentation.main_activity.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikhail.effectivemobiletestquest.presentation.screens.sign_in.SignInScreen
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.bottom_nav.BottomNavigationBar

private const val ROOT = "root_graph"
private const val REGISTRATION = "registration_graph"
private const val BOTTOM_NAV = "bottomNav"

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "sign_in"
    ) {
        composable(route = "sign_in") {
            SignInScreen(navController = navController)
        }
        composable(route = "bottomNav") {
            BottomNavigationBar()
        }
    }
}