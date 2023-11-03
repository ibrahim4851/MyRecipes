package com.ibrahim.myrecipes.domain.usecase.recipe

import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class DeleteRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    fun deleteRecipe(recipe: Recipe) {
        repository.deleteRecipe(recipe)
    }
}