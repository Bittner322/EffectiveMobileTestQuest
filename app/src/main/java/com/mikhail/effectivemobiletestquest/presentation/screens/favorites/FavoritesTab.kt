package com.mikhail.effectivemobiletestquest.presentation.screens.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.data.database.models.ProductWithImagesModel
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.ProductCard

@Composable
fun FavoritesTab(
    products: List<ProductWithImagesModel>,
    onFavoriteClick: (ProductWithImagesModel) -> Unit,
    onNonFavoriteClick: (ProductWithImagesModel) -> Unit,
) {
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
                    onFavoriteClick = { onFavoriteClick(it) },
                    onNonFavoriteClick = { onNonFavoriteClick(it) }
                )
            }
        }
    }
}