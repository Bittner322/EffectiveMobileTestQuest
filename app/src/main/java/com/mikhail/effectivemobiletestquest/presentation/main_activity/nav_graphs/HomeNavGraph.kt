package com.mikhail.effectivemobiletestquest.presentation.main_activity.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikhail.effectivemobiletestquest.presentation.screens.cart.CartScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.catalog.CatalogScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.favorites.FavoritesScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.home.HomeScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.product.ProductScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.profile.ProfileScreen
import com.mikhail.effectivemobiletestquest.presentation.screens.sales.SalesScreen
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.bottom_nav.BottomNavScreens

@Composable
fun HomeNavGraph(
    navController: NavHostController,
    onLogout: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreens.Catalog.route
    ) {
        composable(BottomNavScreens.Home.route) {
            HomeScreen()
        }
        composable(BottomNavScreens.Catalog.route) {
            CatalogScreen(navController = navController)
        }
        composable(BottomNavScreens.Cart.route) {
            CartScreen()
        }
        composable(BottomNavScreens.Sales.route) {
            SalesScreen()
        }
        composable(BottomNavScreens.Profile.route) {
            ProfileScreen(
                navController = navController,
                onLogout = onLogout
            )
        }
        composable(route = "${Routes.product}/{productId}") {
            ProductScreen(navController = navController)
        }
        composable(route = Routes.favorites) {
            FavoritesScreen(navController = navController)
        }
    }
}