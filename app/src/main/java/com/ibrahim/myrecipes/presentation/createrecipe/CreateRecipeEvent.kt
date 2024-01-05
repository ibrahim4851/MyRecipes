package com.ibrahim.myrecipes.presentation.createrecipe

import android.net.Uri
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.repository.Ingredients

sealed class CreateRecipeEvent {

    data class SetTitleMinuteServings(val title: String, val minute: Int, val servings: Int): CreateRecipeEvent()

    data class SetCategory(val category: FoodCategory): CreateRecipeEvent()

    data class SetIngredients(val ingredients: Ingredients): CreateRecipeEvent()

    data class SetInstructions(val instructions: List<String>): CreateRecipeEvent()

    data class SetImage(val uri: Uri): CreateRecipeEvent()

    data object SaveRecipe : CreateRecipeEvent()

}