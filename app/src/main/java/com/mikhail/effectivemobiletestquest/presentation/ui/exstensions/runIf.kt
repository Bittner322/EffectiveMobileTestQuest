package com.mikhail.effectivemobiletestquest.presentation.ui.exstensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Modifier.runIf(
    condition: Boolean,
    then: @Composable Modifier.() -> Modifier
): Modifier {
    return if (condition) {
        then()
    } else {
        this
    }
}