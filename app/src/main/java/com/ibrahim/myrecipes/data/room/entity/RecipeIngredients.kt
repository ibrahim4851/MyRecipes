package com.ibrahim.myrecipes.data.room.entity

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeIngredients(
    @Embedded var recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "ownerRecipeId"
    )
    var ingredients: List<IngredientEntity>
)
