package com.mikhail.effectivemobiletestquest.presentation.screens.tabs_navigation_screen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mikhail.effectivemobiletestquest.presentation.main_activity.nav_graphs.HomeNavGraph
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.bottom_nav.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabsNavigationScreen() {
    val bottomBarNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = bottomBarNavController) }
    ) {
        HomeNavGraph(navController = bottomBarNavController)
    }
}