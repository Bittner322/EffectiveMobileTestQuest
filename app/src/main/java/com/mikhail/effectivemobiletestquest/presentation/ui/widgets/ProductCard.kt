package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.data.database.models.ProductModel
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

private const val DefaultPhotosCount = 2

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductCard(
    product: ProductModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = EffectiveTheme.color.white)
            .border(
                width = 1.dp,
                color = EffectiveTheme.color.lightGrey,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Icon(
            modifier = Modifier
                .padding(
                    top = 6.dp,
                    end = 6.dp
                )
                .align(Alignment.End),
            painter = if (product.isFavorite) {
                painterResource(R.drawable.ic_favorite_filled)
            } else {
                painterResource(R.drawable.ic_favorite_unfilled)
            },
            contentDescription = null,
            tint = EffectiveTheme.color.pink
        )

        val pagerState = rememberPagerState(
            pageCount = { DefaultPhotosCount }
        )

        HorizontalPager(
            state = pagerState
        ) { page ->
            Text(
                text = "Page: $page",
            )
        }
    }
}