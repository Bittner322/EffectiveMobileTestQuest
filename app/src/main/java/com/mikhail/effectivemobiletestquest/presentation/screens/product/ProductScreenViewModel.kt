package com.mikhail.effectivemobiletestquest.presentation.screens.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.effectivemobiletestquest.data.database.models.ProductWithImagesModel
import com.mikhail.effectivemobiletestquest.data.repositories.ProductsRepository
import com.mikhail.effectivemobiletestquest.di.annotations.ProductId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductScreenViewModel @Inject constructor(
    @ProductId productId: String,
    private val repository: ProductsRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ProductScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    val product = repository.getProductFlow(productModelId = productId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = ProductWithImagesModel.default
        )

    fun onProductFavoriteClick(product: ProductWithImagesModel) {
        viewModelScope.launch {
            repository.setProductFavorite(product)
        }
    }

    fun onProductNonFavoriteClick(product: ProductWithImagesModel) {
        viewModelScope.launch {
            repository.setProductNonFavorite(product)
        }
    }

    fun onHideOrOpenDescriptionClick() {
        _uiState.update {
            it.copy(isDescriptionVisible = !_uiState.value.isDescriptionVisible)
        }
    }
}