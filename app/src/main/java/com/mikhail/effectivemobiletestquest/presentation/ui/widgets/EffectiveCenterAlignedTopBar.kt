package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults.EffectiveTopBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EffectiveCenterAlignedTopBar(
    text: String,
    modifier: Modifier = Modifier
) {
   CenterAlignedTopAppBar(
       modifier = modifier,
       title = {
           Text(
               text = text,
               color = EffectiveTheme.color.black,
               style = EffectiveTheme.typography.title1,
               overflow = TextOverflow.Ellipsis
           )
       },
       colors = EffectiveTopBarDefaults.topBarColors()
   )
}