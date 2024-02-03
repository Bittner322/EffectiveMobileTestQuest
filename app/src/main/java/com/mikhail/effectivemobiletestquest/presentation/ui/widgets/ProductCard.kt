package com.mikhail.effectivemobiletestquest.presentation.ui.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.data.database.models.ProductWithImagesModel
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

private const val DescriptionMaxLinesCount = 3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductCard(
    product: ProductWithImagesModel,
    onProductCardClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onNonFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = EffectiveTheme.color.white
            )
            .border(
                width = 1.dp,
                color = EffectiveTheme.color.lightGrey,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .clickable { onProductCardClick() }
    ) {
        Icon(
            modifier = Modifier
                .padding(
                    top = 6.dp,
                    end = 6.dp
                )
                .align(Alignment.End)
                .clip(CircleShape)
                .clickable {
                    if (product.productModel.isFavorite) {
                        onNonFavoriteClick()
                    } else {
                        onFavoriteClick()
                    }
                },
            painter = if (product.productModel.isFavorite) {
                painterResource(R.drawable.ic_favorite_filled)
            } else {
                painterResource(R.drawable.ic_favorite_unfilled)
            },
            contentDescription = null,
            tint = EffectiveTheme.color.pink
        )

        val pagerState = rememberPagerState(
            pageCount = { product.images.size }
        )

        HorizontalPager(
            state = pagerState
        ) { page ->
            Image(
                painter = painterResource(product.images[page]),
                contentDescription = null
            )
        }

        EffectivePagerIndicator(pagerState = pagerState)

        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 4.dp
                ),
            text = "${product.productModel.price} ${product.productModel.unit}",
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
                text = "${product.productModel.priceWithDiscount} ${product.productModel.unit}",
                style = EffectiveTheme.typography.title2,
                color = EffectiveTheme.color.black,
                overflow = TextOverflow.Ellipsis
            )
            EffectiveDiscount(discount = product.productModel.discount)
        }

        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 4.dp
                ),
            text = product.productModel.productName,
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
            text = product.productModel.description,
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
                text = "${product.productModel.rating}",
                style = EffectiveTheme.typography.elementText,
                color = EffectiveTheme.color.orange,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "(${product.productModel.countOfFeedbacks})",
                style = EffectiveTheme.typography.elementText,
                color = EffectiveTheme.color.grey,
                overflow = TextOverflow.Ellipsis
            )
        }

        Box(
            modifier = Modifier
                .background(
                    color = EffectiveTheme.color.pink,
                    shape = RoundedCornerShape(
                        topStart = 8.dp,
                        bottomEnd = 8.dp
                    )
                )
                .align(Alignment.End)
                .clickable { }
        ) {
            Icon(
                modifier = Modifier
                    .padding(4.dp),
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = null,
                tint = EffectiveTheme.color.white
            )
        }
    }
}