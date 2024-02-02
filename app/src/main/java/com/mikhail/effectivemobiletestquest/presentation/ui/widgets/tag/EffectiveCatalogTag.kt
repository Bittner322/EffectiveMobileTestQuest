package com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.exstensions.runIf
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

@Composable
fun EffectiveCatalogTag(
    tag: Tag,
    onTagClick: () -> Unit,
    onDisableTagClick: () -> Unit,
    modifier: Modifier = Modifier,
    isActive: Boolean = false
) {
    Row(
        modifier = modifier
            .runIf(isActive) {
                background(
                    color = EffectiveTheme.color.darkBlue,
                    shape = CircleShape
                )
            }
            .runIf(!isActive) {
                background(
                    color = EffectiveTheme.color.lightGrey,
                    shape = CircleShape
                )
            }
            .clip(CircleShape)
            .clickable { onTagClick() }
            .animateContentSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            modifier = Modifier
                .runIf(!isActive) {
                    padding(
                        vertical = 6.dp,
                        horizontal = 12.dp
                    )
                }
                .runIf(isActive) {
                    padding(
                        start = 12.dp,
                        top = 6.dp,
                        bottom = 6.dp
                    )
                },
            text = stringResource(tag.tag),
            style = EffectiveTheme.typography.title4,
            color = if (isActive) {
                EffectiveTheme.color.white
            } else {
                EffectiveTheme.color.grey
            },
            overflow = TextOverflow.Ellipsis
        )
        AnimatedVisibility(visible = isActive) {
            Icon(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .clip(CircleShape)
                    .clickable { onDisableTagClick() },
                painter = painterResource(R.drawable.ic_tag_cross),
                contentDescription = null,
                tint = if (isActive) {
                    EffectiveTheme.color.white
                } else {
                    EffectiveTheme.color.grey
                }
            )
        }
    }
}