package com.mikhail.effectivemobiletestquest.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveCenterAlignedTopBar
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveClickableMenuItem

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    val userInfo by viewModel.userInfo.collectAsState()
    val favoritesCount by viewModel.favoritesCount.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = EffectiveTheme.color.white
            )
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        EffectiveCenterAlignedTopBar(
            text = stringResource(R.string.profile_topbar_title)
        )

        Column(
            modifier = Modifier.padding(
                top = 24.dp,
                start = 16.dp,
                end = 16.dp
            )
        ) {
            EffectiveClickableMenuItem(
                mainText = "${userInfo.name} ${userInfo.surname}",
                endIcon = R.drawable.ic_logout,
                endIconTint = EffectiveTheme.color.darkGrey,
                startIcon = R.drawable.ic_profile,
                startIconTint = EffectiveTheme.color.darkGrey,
                additionalText = userInfo.phoneNumber
            )
        }

        Column(
            modifier = Modifier.padding(
                top = 24.dp,
                start = 16.dp,
                end = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EffectiveClickableMenuItem(
                mainText = stringResource(R.string.profile_favorites),
                endIcon = R.drawable.ic_arrow_right,
                endIconTint = EffectiveTheme.color.darkGrey,
                startIcon = R.drawable.ic_favorite_unfilled,
                startIconTint = EffectiveTheme.color.pink,
                additionalText = "$favoritesCount " +
                        stringResource(R.string.profile_favorites_products)
            )
            EffectiveClickableMenuItem(
                mainText = stringResource(R.string.profile_shops),
                endIcon = R.drawable.ic_arrow_right,
                endIconTint = EffectiveTheme.color.darkGrey,
                startIcon = R.drawable.ic_shop,
                startIconTint = EffectiveTheme.color.pink
            )
            EffectiveClickableMenuItem(
                mainText = stringResource(R.string.profile_feedback),
                endIcon = R.drawable.ic_arrow_right,
                endIconTint = EffectiveTheme.color.darkGrey,
                startIcon = R.drawable.ic_feedback,
                startIconTint = EffectiveTheme.color.orange
            )
            EffectiveClickableMenuItem(
                mainText = stringResource(R.string.profile_offer),
                endIcon = R.drawable.ic_arrow_right,
                endIconTint = EffectiveTheme.color.darkGrey,
                startIcon = R.drawable.ic_offer,
                startIconTint = EffectiveTheme.color.grey
            )
            EffectiveClickableMenuItem(
                mainText = stringResource(R.string.profile_refund),
                endIcon = R.drawable.ic_arrow_right,
                endIconTint = EffectiveTheme.color.darkGrey,
                startIcon = R.drawable.ic_refund,
                startIconTint = EffectiveTheme.color.grey
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 32.dp
                )
                .fillMaxWidth()
                .background(
                    color = EffectiveTheme.color.lightGrey,
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
                .clickable {  }
                .padding(vertical = 16.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(R.string.profile_logout),
                style = EffectiveTheme.typography.buttonText2,
                color = EffectiveTheme.color.black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}