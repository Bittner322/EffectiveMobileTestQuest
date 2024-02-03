package com.mikhail.effectivemobiletestquest.presentation.screens.product

data class ProductScreenUiState(
    val isFavorite: Boolean,
    val isDescriptionVisible: Boolean
) {
    companion object {
        val default = ProductScreenUiState(
            isFavorite = false,
            isDescriptionVisible = true
        )
    }
}