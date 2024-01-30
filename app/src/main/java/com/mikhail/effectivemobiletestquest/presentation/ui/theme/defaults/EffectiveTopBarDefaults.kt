package com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

object EffectiveTopBarDefaults {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun topBarColors(
        containerColor: Color = EffectiveTheme.color.white
    ): TopAppBarColors {
        return TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor
        )
    }
}