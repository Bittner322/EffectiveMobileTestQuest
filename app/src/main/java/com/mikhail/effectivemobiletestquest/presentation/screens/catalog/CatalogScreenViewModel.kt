package com.mikhail.effectivemobiletestquest.presentation.screens.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.effectivemobiletestquest.data.database.models.ProductModel
import com.mikhail.effectivemobiletestquest.data.repositories.ProductsRepository
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.dropdown.SortType
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag.Tag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogScreenViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(CatalogScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    private val _productsFlow = MutableStateFlow(emptyList<ProductModel>())
    val productsFlow = _productsFlow.asStateFlow()

    init {
        loadAllProducts()
        getAllProducts()
    }

    private fun loadAllProducts() {
        viewModelScope.launch {
            repository.loadAllProductsIntoDatabase()
        }
    }

    private fun getAllProducts() {
        repository.getAllProductsFromDatabase()
            .onEach {
                _productsFlow.value = it
            }
            .launchIn(viewModelScope)
    }

    fun onSortTypeChange(sortType: SortType) {
        _uiState.update {
            it.copy(sortType = sortType)
        }
    }

    fun onActiveTagChange(tag: Tag) {
        _uiState.update {
            it.copy(activeTag = tag)
        }
    }

    fun onDisableTagClick() {
        _uiState.update {
            it.copy(activeTag = Tag.ALL)
        }
    }

    fun onProductFavoriteClick(product: ProductModel) {
        viewModelScope.launch {
            repository.setProductFavorite(product)
        }
    }

    fun onProductNonFavoriteClick(product: ProductModel) {
        viewModelScope.launch {
            repository.setProductNonFavorite(product)
        }
    }
}