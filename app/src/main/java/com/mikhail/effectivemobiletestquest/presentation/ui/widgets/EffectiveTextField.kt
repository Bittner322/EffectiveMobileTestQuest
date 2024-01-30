package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults.EffectiveTextFieldDefaults

@Composable
fun EffectiveTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    singleLine: Boolean = false,
    charsLimit: Int = Int.MAX_VALUE,
    placeholder: @Composable (() -> Unit)? = null
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = {
            if (it.length <= charsLimit) {
                onValueChange(it)
            }
        },
        singleLine = singleLine,
        placeholder = placeholder,
        shape = RoundedCornerShape(8.dp),
        colors = EffectiveTextFieldDefaults.textFieldColors()
    )
}