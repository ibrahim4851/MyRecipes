package com.ibrahim.myrecipes.data.room.mapper

import com.ibrahim.myrecipes.data.room.entity.RecipeEntity
import com.ibrahim.myrecipes.domain.model.Recipe

fun RecipeEntity.toRecipe(): Recipe {

    return Recipe(
        recipeId = recipeId,
        recipeTitle = recipeTitle,
        recipeDescription = recipeDescription,
        recipeInstructions = recipeInstructions,
        recipeTime = recipeTime,
        recipeServings = recipeServings,
        recipePhotoUri = recipePhotoUri,
        foodCategory = foodCategory
    )

}

fun Recipe.toRecipeEntity(): RecipeEntity {

    return RecipeEntity(
        recipeId = recipeId,
        recipeTitle = recipeTitle,
        recipeDescription = recipeDescription,
        recipeInstructions = recipeInstructions,
        recipeTime = recipeTime,
        recipeServings = recipeServings,
        recipePhotoUri = recipePhotoUri,
        foodCategory = foodCategory
    )

}