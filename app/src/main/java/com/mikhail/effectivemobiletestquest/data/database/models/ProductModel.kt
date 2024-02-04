package com.mikhail.effectivemobiletestquest.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProductModel")
data class ProductModel(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "productName")
    val productName: String,
    @ColumnInfo(name = "subtitle")
    val subtitle: String,
    @ColumnInfo(name = "tags")
    val tags: List<String>,
    @ColumnInfo(name = "available")
    val available: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "ingredients")
    val ingredients: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "discount")
    val discount: Int,
    @ColumnInfo(name = "priceWithDiscount")
    val priceWithDiscount: String,
    @ColumnInfo(name = "unit")
    val unit: String,
    @ColumnInfo(name = "count")
    val countOfFeedbacks: Int,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "info")
    val info: List<ProductInfoModel>,
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean,
    @ColumnInfo(name = "priceWithDiscountConvertedToInt")
    val priceWithDiscountConvertedToInt: Int
)