package com.mikhail.effectivemobiletestquest.data.repositories

import com.mikhail.effectivemobiletestquest.data.database.AppDatabase
import com.mikhail.effectivemobiletestquest.data.database.models.ProductInfoModel
import com.mikhail.effectivemobiletestquest.data.database.models.ProductModel
import com.mikhail.effectivemobiletestquest.data.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val networkService: NetworkService,
    private val database: AppDatabase
) {
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

    fun getAllProductsFromDatabase(): Flow<List<ProductModel>> {
        return database.productsDao().getProductsData()
            .flowOn(Dispatchers.IO)
    }

    suspend fun setProductFavorite(productModel: ProductModel) {
        withContext(Dispatchers.IO) {
            database.productsDao().setProductFavorite(productModel.id)
        }
    }

    suspend fun setProductNonFavorite(productModel: ProductModel) {
        withContext(Dispatchers.IO) {
            database.productsDao().setProductNonFavorite(productModel.id)
        }
    }

    suspend fun clearProducts() {
        withContext(Dispatchers.IO) {
            database.productsDao().clearProductsData()
        }
    }
}