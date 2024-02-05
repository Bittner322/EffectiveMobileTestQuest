package com.mikhail.effectivemobiletestquest.presentation.main_activity.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikhail.effectivemobiletestquest.presentation.screens.sign_in.SignInScreen
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.bottom_nav.BottomNavigationBar

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    isUserLogged: Boolean,
    onLogout: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = if (isUserLogged) Routes.bottomNav else Routes.sign_in
    ) {
        composable(route = Routes.sign_in) {
            SignInScreen(navController = navController)
        }
        composable(route = Routes.bottomNav) {
            BottomNavigationBar(
                onLogout = onLogout
            )
        }
    }
}