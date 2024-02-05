package com.mikhail.effectivemobiletestquest.presentation.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.defaults.EffectiveTopBarDefaults

private const val ProductScreenRoute = "product"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    navController: NavController,
    viewModel: FavoritesScreenViewModel = hiltViewModel()
) {
    val products by viewModel.productsFlow.collectAsState()

    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        stringResource(id = R.string.favorites_products_tab),
        stringResource(id = R.string.favorites_brands_tab)
    )

    LaunchedEffect(Unit) {
        viewModel.uiAction.collect {
            when (it) {
                is FavoritesAction.NavToProduct -> {
                    navController.navigate("$ProductScreenRoute/${it.product.productModel.id}")
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = EffectiveTheme.color.white)
            .systemBarsPadding()
    ) {
        TopAppBar(
            navigationIcon = {
                Icon(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clip(CircleShape)
                        .clickable { navController.popBackStack() },
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = null,
                    tint = EffectiveTheme.color.black
                )
            },
            title = {
                Text(
                    modifier = Modifier.padding(start = 28.dp),
                    text = stringResource(R.string.favorites_topbar_title),
                    style = EffectiveTheme.typography.title1,
                    color = EffectiveTheme.color.black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            colors = EffectiveTopBarDefaults.topBarColors()
        )

        TabRow(
            modifier = Modifier
                .padding(
                    top = 4.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                .clip(RoundedCornerShape(8.dp)),
            indicator = { _: List<TabPosition> ->
                Box {}
            },
            divider = { Box {} },
            selectedTabIndex = tabIndex,
            containerColor = EffectiveTheme.color.lightGrey
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    modifier = Modifier
                        .padding(4.dp)
                        .background(
                            color = if (tabIndex == index) {
                                EffectiveTheme.color.white
                            } else {
                                EffectiveTheme.color.lightGrey
                            },
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(RoundedCornerShape(8.dp)),
                    text = {
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = title,
                            style = EffectiveTheme.typography.buttonText2,
                            color = if (tabIndex == index) {
                                EffectiveTheme.color.black
                            } else {
                                EffectiveTheme.color.grey
                            },
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> FavoritesTab(
                products = products,
                onFavoriteClick = viewModel::onProductFavoriteClick,
                onNonFavoriteClick = viewModel::onProductNonFavoriteClick,
                onProductClick = viewModel::onProductClick
            )
            1 -> BrandsTab()
        }
    }
}