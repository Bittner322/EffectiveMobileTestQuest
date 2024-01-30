package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults.EffectiveButtonDefaults

@Composable
fun EffectiveSingleLineButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = false
) {
    Button(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        colors = EffectiveButtonDefaults.buttonDefaults(),
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            style = EffectiveTheme.typography.buttonText2,
            text = text
        )
    }
}