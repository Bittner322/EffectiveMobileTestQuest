package com.mikhail.effectivemobiletestquest.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("items")
    val items: List<Item>
) {
    @Serializable
    data class Item(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("subtitle")
        val subtitle: String,
        @SerialName("price")
        val price: Price,
        @SerialName("feedback")
        val feedback: Feedback,
        @SerialName("tags")
        val tags: List<String>,
        @SerialName("available")
        val available: Int,
        @SerialName("description")
        val description: String,
        @SerialName("info")
        val info: List<Info>,
        @SerialName("ingredients")
        val ingredients: String
    ) {
        @Serializable
        data class Price(
            @SerialName("price")
            val price: String,
            @SerialName("discount")
            val discount: Int,
            @SerialName("priceWithDiscount")
            val priceWithDiscount: String,
            @SerialName("unit")
            val unit: String
        )
        @Serializable
        data class Feedback(
            @SerialName("count")
            val count: Int,
            @SerialName("rating")
            val rating: Double
        )
        @Serializable
        data class Info(
            @SerialName("title")
            val title: String,
            @SerialName("value")
            val value: String
        )
    }
}