package com.ibrahim.myrecipes.presentation.recipedetail.viewmodel

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Ingredient

sealed class RecipeDetailEvent {

    data class UpdateRecipeTitleEvent(val newRecipeTitle: String): RecipeDetailEvent()

    data class UpdateIngredientEvent(val ingredient: Ingredient): RecipeDetailEvent()

    data class UpdateFoodCategoryEvent(val foodCategory: FoodCategory): RecipeDetailEvent()

    data class DeleteIngredientEvent(val ingredientId: Long): RecipeDetailEvent()

    data class DeleteInstructionEvent(val position: Int): RecipeDetailEvent()

    data class UpdateInstructionEvent(val newInstruction: String, val position: Int): RecipeDetailEvent()

    data class AddInstructionEvent(val newInstruction: String): RecipeDetailEvent()

    data class AddIngredientEvent(val newIngredient: Ingredient): RecipeDetailEvent()
    data class UpdateServingsAndTimeEvent(val updatedServings: Int, val updatedTime: Int) : RecipeDetailEvent()

}