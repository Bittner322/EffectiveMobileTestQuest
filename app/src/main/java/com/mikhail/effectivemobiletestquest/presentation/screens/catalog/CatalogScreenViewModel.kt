package com.mikhail.effectivemobiletestquest.presentation.screens.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.effectivemobiletestquest.data.database.models.ProductWithImagesModel
import com.mikhail.effectivemobiletestquest.data.repositories.ProductsRepository
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.dropdown.SortType
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag.Tag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogScreenViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(CatalogScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    private val _productsFlow = MutableStateFlow(emptyList<ProductWithImagesModel>())
    val productsFlow = _productsFlow.asStateFlow()

    private val isProductTableEmpty = repository.checkIsTableEmpty()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = false
        )

    init {
        if (isProductTableEmpty.value) {
            getAllProducts()
        } else {
            loadAllProducts()
            getAllProducts()
        }
    }

    private fun loadAllProducts() {
        viewModelScope.launch {
            repository.loadAllProductsIntoDatabase()
        }
    }

    private fun getAllProducts() {
        repository.getAllProductsSortedByPopularity()
            .onEach {
                _productsFlow.value = it
            }
            .launchIn(viewModelScope)
    }

    private fun getAllProductsByTag() {
        repository.getAllProductsByTag(tag = _uiState.value.activeTag)
            .onEach {
                _productsFlow.value = it
            }
            .launchIn(viewModelScope)
    }

    fun onSortTypeChange(sortType: SortType) {
        _uiState.update {
            it.copy(sortType = sortType)
        }
        when (sortType) {
            SortType.BY_POPULARITY -> onSortByPopularityClick()
            SortType.BY_PRICE_UP -> onSortByPriceClick()
            SortType.BY_PRICE_DOWN -> onSortByPriceDescClick()
        }
    }

    fun onActiveTagChange(tag: Tag) {
        _uiState.update {
            it.copy(activeTag = tag)
        }
        if (tag == Tag.ALL) {
            getAllProducts()
        } else {
            getAllProductsByTag()
        }
    }

    fun onDisableTagClick() {
        _uiState.update {
            it.copy(activeTag = Tag.ALL)
        }
        getAllProducts()
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

    private fun onSortByPopularityClick() {
        repository.getAllProductsSortedByPopularity()
            .onEach {
                _productsFlow.value = it
            }
            .launchIn(viewModelScope)
    }

    private fun onSortByPriceClick() {
        repository.getAllProductsSortedByPrice()
            .onEach {
                _productsFlow.value = it
            }
            .launchIn(viewModelScope)
    }

    private fun onSortByPriceDescClick() {
        repository.getAllProductsSortedByPriceDesc()
            .onEach {
                _productsFlow.value = it
            }
            .launchIn(viewModelScope)
    }
}