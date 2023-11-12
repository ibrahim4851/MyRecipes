package com.ibrahim.myrecipes.domain.model

import android.os.Parcelable
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Ingredient(
    val ingredientId: Long,
    val ownerRecipeId: Long?,
    var ingredientName: String,
    var ingredientQuantity: BigDecimal?,
    var ingredientQuantityUnit: IngredientQuantityUnit
) : Parcelable