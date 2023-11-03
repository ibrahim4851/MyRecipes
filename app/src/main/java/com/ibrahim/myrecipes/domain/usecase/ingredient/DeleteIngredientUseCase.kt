package com.ibrahim.myrecipes.domain.usecase.ingredient

import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class DeleteIngredientUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    fun deleteRecipe(ingredient: Ingredient) {
        repository.deleteIngredient(ingredient)
    }
}