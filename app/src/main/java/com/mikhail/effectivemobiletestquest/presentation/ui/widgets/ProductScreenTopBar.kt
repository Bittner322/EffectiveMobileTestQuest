package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults.EffectiveTopBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreenTopBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier
            .padding(horizontal = 20.dp),
        title = { /*empty*/ },
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onBackClick() },
                painter = painterResource(R.drawable.ic_arrow_left),
                contentDescription = null
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_share),
                contentDescription = null
            )
        },
        colors = EffectiveTopBarDefaults.topBarColors()
    )
}