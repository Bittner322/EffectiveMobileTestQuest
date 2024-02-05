package com.mikhail.effectivemobiletestquest.presentation.ui.widgets.bottom_nav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.mikhail.effectivemobiletestquest.presentation.main_activity.nav_graphs.HomeNavGraph
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults.EffectiveBottomNavDefaults

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(
    onLogout: () -> Unit
) {
    var navigationSelectedItem by remember {
        mutableIntStateOf(1)
    }

    val mainNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = EffectiveTheme.color.white
            ) {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        label = {
                            Text(
                                text = stringResource(navigationItem.label),
                                style = EffectiveTheme.typography.caption1
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(navigationItem.icon),
                                contentDescription = null
                            )
                        },
                        onClick = {
                            navigationSelectedItem = index
                            mainNavController.navigate(navigationItem.route)
                        },
                        alwaysShowLabel = true,
                        colors = EffectiveBottomNavDefaults.bottomNavItemColors()
                    )
                }
            }
        }
    ) { _ ->
        HomeNavGraph(
            navController = mainNavController,
            onLogout = onLogout
        )
    }
}