package com.mikhail.effectivemobiletestquest.presentation.screens.product

import androidx.lifecycle.ViewModel
import com.mikhail.effectivemobiletestquest.data.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductScreenViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ProductScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    //val
}