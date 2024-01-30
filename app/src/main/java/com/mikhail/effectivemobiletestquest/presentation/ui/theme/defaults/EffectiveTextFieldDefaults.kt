package com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults

import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

object EffectiveTextFieldDefaults {

    @Composable
    fun textFieldColors(
        placeholderColor: Color = EffectiveTheme.color.grey,
        textColor: Color = EffectiveTheme.color.black,
        containerColor: Color = EffectiveTheme.color.lightGrey,
        indicatorColor: Color = Color.Transparent
    ): TextFieldColors {

        return TextFieldDefaults.colors(
            cursorColor = textColor,
            disabledPlaceholderColor = placeholderColor,
            focusedPlaceholderColor = placeholderColor,
            unfocusedPlaceholderColor = placeholderColor,
            errorPlaceholderColor = placeholderColor,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedIndicatorColor = indicatorColor,
            unfocusedIndicatorColor = indicatorColor,
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor
        )
    }
}