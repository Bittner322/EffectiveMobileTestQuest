package com.mikhail.effectivemobiletestquest.presentation.ui.widgets.bottom_nav

private const val HomeScreenRoute = "home"
private const val CatalogScreenRoute = "catalog"
private const val CartScreenRoute = "cart"
private const val SalesScreenRoute = "sales"
private const val ProfilesScreenRoute = "profile"

sealed class BottomNavScreens(val route: String) {
    data object Home: BottomNavScreens(route = HomeScreenRoute)
    data object Catalog: BottomNavScreens(route = CatalogScreenRoute)
    data object Cart: BottomNavScreens(route = CartScreenRoute)
    data object Sales: BottomNavScreens(route = SalesScreenRoute)
    data object Profile: BottomNavScreens(route = ProfilesScreenRoute)
}