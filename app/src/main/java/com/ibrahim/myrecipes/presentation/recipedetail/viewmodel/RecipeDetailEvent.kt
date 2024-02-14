package com.ibrahim.myrecipes.presentation.recipedetail.viewmodel

import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.model.Recipe

sealed class RecipeDetailEvent {

    data class UpdateRecipeEvent(val recipe: Recipe): RecipeDetailEvent()

    data class UpdateIngredientEvent(val ingredient: Ingredient): RecipeDetailEvent()

}