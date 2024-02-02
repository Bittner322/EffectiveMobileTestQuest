package com.mikhail.effectivemobiletestquest.data.database

import androidx.room.TypeConverter
import com.mikhail.effectivemobiletestquest.data.database.models.ProductInfoModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductInfoConverter {
   @TypeConverter
   fun fromList(value : List<ProductInfoModel>) = Json.encodeToString(value)

   @TypeConverter
   fun toList(value: String) = Json.decodeFromString<List<ProductInfoModel>>(value)
}