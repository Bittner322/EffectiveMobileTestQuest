package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.data.database.models.ProductModel
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

private const val DefaultPhotosCount = 2
private const val DescriptionMaxLinesCount = 3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductCard(
    product: ProductModel,
    onFavoriteClick: () -> Unit,
    onNonFavoriteClick: () -> Unit,
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
                .align(Alignment.End)
                .clickable {
                    if (product.isFavorite) {
                        onNonFavoriteClick()
                    } else {
                        onFavoriteClick()
                    }
                },
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

        EffectivePagerIndicator(pagerState = pagerState)

        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 4.dp
                ),
            text = "${product.price} ${product.unit}",
            style = EffectiveTheme.typography.elementText,
            color = EffectiveTheme.color.grey,
            textDecoration = TextDecoration.LineThrough,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 4.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "${product.priceWithDiscount} ${product.unit}",
                style = EffectiveTheme.typography.title2,
                color = EffectiveTheme.color.black,
                overflow = TextOverflow.Ellipsis
            )
            EffectiveDiscount(discount = product.discount)
        }

        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 4.dp
                ),
            text = product.productName,
            style = EffectiveTheme.typography.title3,
            color = EffectiveTheme.color.black,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 2.dp
                ),
            text = product.description,
            style = EffectiveTheme.typography.caption1,
            color = EffectiveTheme.color.darkGrey,
            maxLines = DescriptionMaxLinesCount,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    top = 4.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_star_filled),
                contentDescription = null,
                tint = EffectiveTheme.color.orange
            )
            Text(
                text = "${product.rating}",
                style = EffectiveTheme.typography.elementText,
                color = EffectiveTheme.color.orange,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "(${product.countOfFeedbacks})",
                style = EffectiveTheme.typography.elementText,
                color = EffectiveTheme.color.grey,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}