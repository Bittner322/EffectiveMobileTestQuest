package com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

object EffectiveButtonDefaults {

    @Composable
    fun buttonDefaults(
        enabledContainerColor: Color = EffectiveTheme.color.pink,
        disabledContainerColor: Color = EffectiveTheme.color.lightPink,
        contentColor: Color = Color.White
    ): ButtonColors {
        return ButtonDefaults.buttonColors(
            containerColor = enabledContainerColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = contentColor,
            contentColor = contentColor
        )
    }
}