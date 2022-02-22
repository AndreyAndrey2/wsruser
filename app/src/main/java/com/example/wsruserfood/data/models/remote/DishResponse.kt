package com.example.wsruserfood.data.models.remote

import com.example.wsruserfood.data.db.entity.DishEntity

data class DishResponse(
    val category: String,
    val dishId: String,
    val icon: String,
    val nameDish: String,
    val price: String,
    val version: String
) {
    fun toEntity(): DishEntity = DishEntity(
        category, dishId, icon, nameDish, price, version
    )
}