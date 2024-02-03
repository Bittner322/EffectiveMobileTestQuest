package com.mikhail.effectivemobiletestquest.data.repositories

import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.data.database.AppDatabase
import com.mikhail.effectivemobiletestquest.data.database.models.ProductInfoModel
import com.mikhail.effectivemobiletestquest.data.database.models.ProductModel
import com.mikhail.effectivemobiletestquest.data.database.models.ProductWithImagesModel
import com.mikhail.effectivemobiletestquest.data.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val networkService: NetworkService,
    private val database: AppDatabase
) {
    private val productsToImagesMap = mapOf(
        "cbf0c984-7c6c-4ada-82da-e29dc698bb50" to listOf(R.drawable.razor, R.drawable.cream),
        "54a876a5-2205-48ba-9498-cfecff4baa6e" to listOf(R.drawable.soap, R.drawable.lotion),
        "75c84407-52e1-4cce-a73a-ff2d3ac031b3" to listOf(R.drawable.cream, R.drawable.razor),
        "16f88865-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.oil_paper, R.drawable.mask),
        "26f88856-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.lotion, R.drawable.oil_paper),
        "15f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.razor, R.drawable.soap),
        "88f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.mask, R.drawable.oil_paper),
        "55f58865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.soap, R.drawable.cream)
    )

    private suspend fun mapProducts(): List<ProductModel> {
        val products = networkService.getProducts().items.map { item ->
            ProductModel(
                id = item.id,
                productName = item.title,
                subtitle = item.subtitle,
                tags = item.tags,
                available = item.available,
                description = item.description,
                ingredients = item.ingredients,
                price = item.price.price,
                discount = item.price.discount,
                priceWithDiscount = item.price.priceWithDiscount,
                unit = item.price.unit,
                countOfFeedbacks = item.feedback.count,
                rating = item.feedback.rating,
                info = item.info.map { itemInfo ->
                    ProductInfoModel(
                        title = itemInfo.title,
                        value = itemInfo.value
                    )
                },
                isFavorite = false
            )
        }
        return products
    }

    suspend fun loadAllProductsIntoDatabase(): Result<Unit> {
        return runCatching {
            database.productsDao().insertAll(mapProducts())
        }
    }

    fun getAllProductsFromDatabase(): Flow<List<ProductWithImagesModel>> {
        return database.productsDao().getProductsData()
            .map {
                it.map { product ->
                    ProductWithImagesModel(
                        productModel = product,
                        images = productsToImagesMap[product.id].orEmpty()
                    )
                }
            }
            .flowOn(Dispatchers.IO)
    }

    suspend fun setProductFavorite(productModel: ProductWithImagesModel) {
        withContext(Dispatchers.IO) {
            database.productsDao().setProductFavorite(productModel.productModel.id)
        }
    }

    suspend fun setProductNonFavorite(productModel: ProductWithImagesModel) {
        withContext(Dispatchers.IO) {
            database.productsDao().setProductNonFavorite(productModel.productModel.id)
        }
    }

    fun getProductFlow(
        productModel: ProductWithImagesModel
    ): Flow<ProductWithImagesModel> {
        return database.productsDao().getProductFlow(productModel.productModel.id)
            .map { product ->
                ProductWithImagesModel(
                    productModel = product,
                    images = productsToImagesMap[product.id].orEmpty()
                )
            }
            .flowOn(Dispatchers.IO)
    }

    suspend fun clearProducts() {
        withContext(Dispatchers.IO) {
            database.productsDao().clearProductsData()
        }
    }
}