package com.ibrahim.myrecipes.domain.usecase.ingredient

import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class UpdateIngredientUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    fun updateRecipe(ingredient: Ingredient) {
        repository.updateIngredient(ingredient)
    }
}