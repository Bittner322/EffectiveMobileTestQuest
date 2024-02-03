package com.mikhail.effectivemobiletestquest.presentation.screens.product

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveDiscount
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectivePagerIndicator
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.ProductScreenTopBar
import com.smarttoolfactory.ratingbar.RatingBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductScreen(
    navController: NavController,
    viewModel: ProductScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val product by viewModel.product.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = EffectiveTheme.color.white
            )
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProductScreenTopBar(
            onBackClick = { navController.popBackStack() }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.End)
                    .clip(CircleShape)
                    .clickable(
                        onClick = {
                            if (product.productModel.isFavorite) {
                                viewModel.onProductNonFavoriteClick(product)
                            } else {
                                viewModel.onProductFavoriteClick(product)
                            }
                        }
                    ),
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
                    modifier = Modifier
                        .heightIn(min = 360.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(product.images[page]),
                    contentDescription = null
                )
            }

            Image(
                painter = painterResource(R.drawable.additional_info),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(32.dp))

            EffectivePagerIndicator(
                pagerState = pagerState,
                dotSize = 6.dp
            )

            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = product.productModel.productName,
                style = EffectiveTheme.typography.title1,
                color = EffectiveTheme.color.grey
            )

            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = product.productModel.subtitle,
                style = EffectiveTheme.typography.largeTitle1,
                color = EffectiveTheme.color.black,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                text = stringResource(R.string.product_available_for_order)
                        + " ${product.productModel.available} "
                        + stringResource(R.string.product_units),
                style = EffectiveTheme.typography.text1,
                color = EffectiveTheme.color.grey,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Box(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .height(1.dp)
                    .background(color = EffectiveTheme.color.lightGrey)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RatingBar(
                    rating = product.productModel.rating.toFloat(),
                    painterEmpty = painterResource(R.drawable.unfilled_star),
                    painterFilled = painterResource(R.drawable.filled_star),
                    itemSize = 20.dp,
                    onRatingChange = { }
                )
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    text = "${product.productModel.rating} · ${product.productModel.countOfFeedbacks} " +
                            stringResource(R.string.product_count_of_feedbacks),
                    style = EffectiveTheme.typography.text1,
                    color = EffectiveTheme.color.grey,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${product.productModel.priceWithDiscount} ${product.productModel.unit}",
                    style = EffectiveTheme.typography.priceText,
                    color = EffectiveTheme.color.black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = "${product.productModel.price} ${product.productModel.unit}",
                    style = EffectiveTheme.typography.text1,
                    color = EffectiveTheme.color.grey,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textDecoration = TextDecoration.LineThrough
                )
                EffectiveDiscount(
                    modifier = Modifier.padding(start = 14.dp),
                    discount = product.productModel.discount
                )
            }
        }
    }
}