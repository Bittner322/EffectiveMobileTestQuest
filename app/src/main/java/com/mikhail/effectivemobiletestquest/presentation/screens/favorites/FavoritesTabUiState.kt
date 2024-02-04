package com.mikhail.effectivemobiletestquest.presentation.screens.favorites

data class FavoritesTabUiState(
    val isFavorite: Boolean
) {
    companion object {
        val default = FavoritesTabUiState(
            isFavorite = false
        )
    }
}
