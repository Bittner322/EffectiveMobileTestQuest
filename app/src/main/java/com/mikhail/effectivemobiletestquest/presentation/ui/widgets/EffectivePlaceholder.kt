package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

@Composable
fun EffectivePlaceholder(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        color = EffectiveTheme.color.grey,
        style = EffectiveTheme.typography.placeholderText
    )
}