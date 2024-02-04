package com.mikhail.effectivemobiletestquest.presentation.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.effectivemobiletestquest.data.database.models.ProductWithImagesModel
import com.mikhail.effectivemobiletestquest.data.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesScreenViewModel @Inject constructor(
    private val repository: ProductsRepository
): ViewModel() {
    private val _productsFlow = MutableStateFlow(emptyList<ProductWithImagesModel>())
    val productsFlow = _productsFlow.asStateFlow()

    init {
        getAllFavoritesProducts()
    }

    private fun getAllFavoritesProducts() {
        repository.getAllFavoriteProducts()
            .onEach {
                _productsFlow.value = it
            }
            .launchIn(viewModelScope)
    }

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
}