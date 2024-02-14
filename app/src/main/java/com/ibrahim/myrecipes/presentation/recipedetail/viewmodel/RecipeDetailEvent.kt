package com.ibrahim.myrecipes.presentation.recipedetail.viewmodel

import com.ibrahim.myrecipes.domain.model.Ingredient

sealed class RecipeDetailEvent {

    data class UpdateRecipeTitleEvent(val newRecipeTitle: String): RecipeDetailEvent()

    data class UpdateIngredientEvent(val ingredient: Ingredient): RecipeDetailEvent()

}