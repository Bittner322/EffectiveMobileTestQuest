package com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults

import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

object EffectiveBottomNavDefaults {

    @Composable
    fun bottomNavItemColors(
        indicatorColor: Color = EffectiveTheme.color.white,
        selectedColor: Color = EffectiveTheme.color.pink,
        unselectedColor: Color = EffectiveTheme.color.darkGrey
    ): NavigationBarItemColors {
        return NavigationBarItemDefaults.colors(
            selectedIconColor = selectedColor,
            unselectedIconColor = unselectedColor,
            selectedTextColor = selectedColor,
            unselectedTextColor = unselectedColor,
            indicatorColor = indicatorColor
        )
    }
}