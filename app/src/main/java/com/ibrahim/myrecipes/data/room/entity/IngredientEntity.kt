package com.ibrahim.myrecipes.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import java.math.BigDecimal

@Entity(tableName = "ingredients")
data class IngredientEntity (
    @PrimaryKey(autoGenerate = true) val ingredientId: Long,
    val recipeId: Int,
    val ingredientName: String,
    val ingredientQuantity: BigDecimal?,
    val ingredientQuantityUnit: IngredientQuantityUnit
)