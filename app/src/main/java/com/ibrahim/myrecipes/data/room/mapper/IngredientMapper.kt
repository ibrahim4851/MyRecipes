package com.ibrahim.myrecipes.data.room.mapper

import com.ibrahim.myrecipes.data.room.entity.IngredientEntity
import com.ibrahim.myrecipes.domain.model.Ingredient

fun IngredientEntity.toIngredient(): Ingredient {

    return Ingredient(
        ingredientId = ingredientId,
        ingredientName = ingredientName,
        ingredientQuantity = ingredientQuantity,
        ingredientQuantityUnit = ingredientQuantityUnit,
        ownerRecipeId = ownerRecipeId
    )

}

fun Ingredient.toIngredientEntity(): IngredientEntity {

    return IngredientEntity(
        ingredientId = ingredientId,
        ingredientName = ingredientName,
        ingredientQuantity = ingredientQuantity,
        ingredientQuantityUnit = ingredientQuantityUnit,
        ownerRecipeId = ownerRecipeId!!
    )

}