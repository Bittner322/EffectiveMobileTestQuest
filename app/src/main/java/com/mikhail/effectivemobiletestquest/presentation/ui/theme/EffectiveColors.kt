package com.mikhail.effectivemobiletestquest.presentation.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class EffectiveColors(
    val white: Color,
    val grey: Color,
    val lightGrey: Color,
    val darkGrey: Color,
    val pink: Color,
    val lightPink: Color,
    val orange: Color,
    val darkBlue: Color,
    val black: Color
)

fun ProvideEffectiveColors(): EffectiveColors {
    return EffectiveColors(
        white = Color(0xFFFFFFFF),
        grey = Color(0xFFA0A1A3),
        lightGrey = Color(0xFFDEDEDE),
        darkGrey = Color(0xFF3E3E3E),
        pink = Color(0xFFD62F89),
        lightPink = Color(0xFFFF8AC9),
        orange = Color(0xFFF9A249),
        darkBlue = Color(0xFF52606D),
        black = Color(0xFF000000),
    )
}

val LocalEffectiveColors = staticCompositionLocalOf<EffectiveColors> {
    error { "LocalEffectiveColors not provided" }
}