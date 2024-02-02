package com.mikhail.effectivemobiletestquest.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity(tableName = "ProductInfoModel")
@Serializable
data class ProductInfoModel(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "value")
    val value: String,
)
