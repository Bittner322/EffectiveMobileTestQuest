package com.mikhail.effectivemobiletestquest.presentation.screens.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveCenterAlignedTopBar
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.ProductCard
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.dropdown.EffectiveSortDropdown
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag.EffectiveCatalogTag
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag.Tag

@Composable
fun CatalogScreen(
    navController: NavController,
    viewModel: CatalogScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val products by viewModel.productsFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = EffectiveTheme.color.white
            )
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EffectiveCenterAlignedTopBar(
            text = stringResource(R.string.catalog_topbar_title)
        )

        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            EffectiveSortDropdown(
                chosenSortType = uiState.sortType,
                onChosenSortTypeClick = viewModel::onSortTypeChange
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_filter),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.catalog_filters),
                    style = EffectiveTheme.typography.title4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        LazyRow(
            modifier = Modifier.padding(top = 16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(Tag.entries.toTypedArray()) { tag ->
                EffectiveCatalogTag(
                    tag = tag,
                    onTagClick = { viewModel.onActiveTagChange(tag) },
                    onDisableTagClick = { viewModel.onDisableTagClick() },
                    isActive = uiState.activeTag == tag
                )
            }
        }
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(products) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProductCard(
                        product = it,
                        onProductCardClick = {  },
                        onFavoriteClick = { viewModel.onProductFavoriteClick(it) },
                        onNonFavoriteClick = { viewModel.onProductNonFavoriteClick(it) }
                    )
                }
            }
        }
    }
}