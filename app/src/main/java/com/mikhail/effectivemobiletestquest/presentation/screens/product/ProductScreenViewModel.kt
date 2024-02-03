package com.mikhail.effectivemobiletestquest.presentation.screens.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.data.database.models.ProductInfoModel
import com.mikhail.effectivemobiletestquest.data.database.models.ProductModel
import com.mikhail.effectivemobiletestquest.data.database.models.ProductWithImagesModel
import com.mikhail.effectivemobiletestquest.data.repositories.ProductsRepository
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
    private val repository: ProductsRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ProductScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    val productModel: ProductWithImagesModel = ProductWithImagesModel(
        productModel = ProductModel(
            id = "cbf0c984-7c6c-4ada-82da-e29dc698bb50",
            productName = "ASDASD",
            subtitle = "ADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DF",
            tags = listOf("tag","tag"),
            available = 12,
            description = "ADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DFADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DFADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DFADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DF",
            ingredients = "ADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DFADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DFADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DFADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DFADSOFNSDIGSDGOMSOGMJGNPSDOGHSDGNPSOIDGOSIGNS:OENGOSNGPONESOGNSEOIFS:DF",
            price = "12313",
            discount = 12,
            priceWithDiscount = "900",
            unit = "P",
            countOfFeedbacks = 123,
            rating = 4.2,
            info = listOf(
                ProductInfoModel(
                    title = "asdasdasdasd",
                    value = "asdasdasda"
                )
            ),
            isFavorite = false,
        ),
        images = listOf(R.drawable.soap, R.drawable.razor)
    )

    val product = repository.getProductFlow(productModel = productModel)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = productModel
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