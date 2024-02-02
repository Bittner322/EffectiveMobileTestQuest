package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

@Composable
fun EffectiveDiscount(
    discount: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = EffectiveTheme.color.pink,
                shape = RoundedCornerShape(4.dp)
            )
    ) {
        Text(
            modifier = Modifier
                .padding(
                    vertical = 3.dp,
                    horizontal = 6.dp
                ),
            text = "-$discount%",
            style = EffectiveTheme.typography.elementText,
            color = EffectiveTheme.color.white,
            overflow = TextOverflow.Ellipsis
        )
    }
}