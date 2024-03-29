package com.mikhail.effectivemobiletestquest.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.mikhail.effectivemobiletestquest.presentation.main_activity.nav_graphs.RootNavigationGraph
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveTheme {
                val navController = rememberNavController()
                RootNavigationGraph(
                    navController = navController,
                    isUserLogged = viewModel.isUserLogged(),
                    onLogout = {
                        navController.navigate("sign_in") {
                            popUpTo(0)
                        }
                    }
                )
            }
        }
    }
}