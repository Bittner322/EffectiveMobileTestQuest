package com.mikhail.effectivemobiletestquest.presentation.ui.widgets.bottom_nav

import com.mikhail.effectivemobiletestquest.R

data class BottomNavigationItem(
    val label: Int = 0,
    val icon: Int = 0,
    val route: String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = R.string.bottom_nav_main,
                icon = R.drawable.ic_home,
                route = BottomNavScreens.Home.route
            ),
            BottomNavigationItem(
                label = R.string.bottom_nav_catalog,
                icon = R.drawable.ic_catalog,
                route = BottomNavScreens.Catalog.route
            ),
            BottomNavigationItem(
                label = R.string.bottom_nav_cart,
                icon = R.drawable.ic_cart,
                route = BottomNavScreens.Cart.route
            ),
            BottomNavigationItem(
                label = R.string.bottom_nav_sales,
                icon = R.drawable.ic_sales,
                route = BottomNavScreens.Sales.route
            ),
            BottomNavigationItem(
                label = R.string.bottom_nav_profile,
                icon = R.drawable.ic_profile,
                route = BottomNavScreens.Profile.route
            )
        )
    }
}