package com.mikhail.effectivemobiletestquest.data.database.models

data class ProductWithImagesModel(
    val productModel: ProductModel,
    val images: List<Int>
) {
    companion object {
        val default = ProductWithImagesModel(
            productModel = ProductModel.default,
            images = emptyList()
        )
    }
}
