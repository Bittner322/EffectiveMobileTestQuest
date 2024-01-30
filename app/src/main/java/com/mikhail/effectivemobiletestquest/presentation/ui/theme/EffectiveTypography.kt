package com.mikhail.effectivemobiletestquest.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.mikhail.effectivemobiletestquest.R

@Immutable
data class EffectiveTypography(
    val largeTitle1: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
    val text1: TextStyle,
    val caption1: TextStyle,
    val buttonText1: TextStyle,
    val buttonText2: TextStyle,
    val elementText: TextStyle,
    val priceText: TextStyle,
    val placeholderText: TextStyle,
    val linkText: TextStyle
)

@Composable
fun ProvideEffectiveTypography(): EffectiveTypography {
    val sfMediumFontFamily = FontFamily(
        fonts = listOf(Font(R.font.sf_pro_display_medium))
    )
    val sfRegularFontFamily = FontFamily(
        fonts = listOf(Font(R.font.sf_pro_display_regular))
    )

    return EffectiveTypography(
        largeTitle1 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            fontFamily = sfMediumFontFamily
        ),
        title1 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            fontFamily = sfMediumFontFamily
        ),
        title2 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            fontFamily = sfMediumFontFamily
        ),
        title3 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            fontFamily = sfMediumFontFamily
        ),
        title4 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            fontFamily = sfRegularFontFamily
        ),
        text1 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            fontFamily = sfRegularFontFamily
        ),
        caption1 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            fontFamily = sfRegularFontFamily
        ),
        buttonText1 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            fontFamily = sfMediumFontFamily
        ),
        buttonText2 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            fontFamily = sfMediumFontFamily
        ),
        elementText = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 9.sp,
            fontFamily = sfRegularFontFamily
        ),
        priceText = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            fontFamily = sfMediumFontFamily
        ),
        placeholderText = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            fontFamily = sfRegularFontFamily
        ),
        linkText = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            fontFamily = sfRegularFontFamily,
            textDecoration = TextDecoration.Underline
        )
    )
}

val LocalEffectiveTypography = staticCompositionLocalOf<EffectiveTypography> {
    error("LocalEffectiveTypography not initialized")
}