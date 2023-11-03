package com.ibrahim.myrecipes.domain.usecase.recipe

import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class UpdateRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    fun updateRecipe(recipe: Recipe) {
        repository.updateRecipe(recipe)
    }
}