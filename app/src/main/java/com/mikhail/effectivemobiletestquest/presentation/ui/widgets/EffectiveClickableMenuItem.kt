package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

@Composable
fun EffectiveClickableMenuItem(
    mainText: String,
    endIcon: Int,
    modifier: Modifier = Modifier,
    startIcon: Int? = null,
    additionalText: String? = null,
    startIconTint: Color? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .background(
                color = EffectiveTheme.color.lightGrey,
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (startIcon != null && startIconTint != null) {
            Icon(
                modifier = Modifier.padding(end = 8.dp),
                painter = painterResource(startIcon),
                contentDescription = null,
                tint = startIconTint
            )
        }
        if (additionalText != null) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = mainText,
                    style = EffectiveTheme.typography.title2,
                    color = EffectiveTheme.color.black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = additionalText,
                    style = EffectiveTheme.typography.caption1,
                    color = EffectiveTheme.color.grey,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        } else {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = mainText,
                style = EffectiveTheme.typography.title2,
                color = EffectiveTheme.color.black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier.padding(end = 8.dp),
            painter = painterResource(endIcon),
            contentDescription = null
        )
    }
}