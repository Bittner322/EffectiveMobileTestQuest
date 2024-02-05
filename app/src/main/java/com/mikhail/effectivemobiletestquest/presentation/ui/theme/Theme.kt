package com.mikhail.effectivemobiletestquest.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp

@Composable
fun EffectiveTheme(
    content: @Composable () -> Unit
) {
    val effectiveTypography = ProvideEffectiveTypography()
    val effectiveColors = ProvideEffectiveColors()

    MaterialTheme {
        CompositionLocalProvider(
            LocalEffectiveColors provides effectiveColors,
            LocalEffectiveTypography provides effectiveTypography,
            content = content
        )
    }
}

object EffectiveTheme {
    val color: EffectiveColors
        @Composable
        get() = LocalEffectiveColors.current
    val typography: EffectiveTypography
        @Composable
        get() = LocalEffectiveTypography.current
}

val bottomNavHeight = 80.dp