package com.mikhail.effectivemobiletestquest.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mikhail.effectivemobiletestquest.data.database.models.ProductModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(productModel: ProductModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(productModel: List<ProductModel>)

    @Update
    suspend fun update(productModel: ProductModel)

    @Delete
    suspend fun delete(productModel: ProductModel)

    @Query("SELECT * FROM ProductModel")
    fun getProductsData(): Flow<List<ProductModel>>

    @Query("UPDATE ProductModel SET isFavorite = 1 WHERE id = (:id)")
    fun setProductFavorite(id: String)

    @Query("UPDATE ProductModel SET isFavorite = 0 WHERE id = (:id)")
    fun setProductNonFavorite(id: String)

    @Query("DELETE FROM ProductModel")
    fun clearProductsData()
}