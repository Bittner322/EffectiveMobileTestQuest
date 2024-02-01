package com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

@Composable
fun EffectiveCatalogTag(
    onTagClick: () -> Unit,
    modifier: Modifier = Modifier
) {


    Row(
        modifier = modifier
            .background(
                color = EffectiveTheme.color.darkBlue,
                shape = CircleShape
            )
            .clickable { onTagClick() },
        verticalAlignment = Alignment.CenterVertically,
    ) {

    }
}