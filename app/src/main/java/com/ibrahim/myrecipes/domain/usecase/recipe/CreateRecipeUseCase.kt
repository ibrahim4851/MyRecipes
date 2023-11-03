package com.ibrahim.myrecipes.domain.usecase.recipe

import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class CreateRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    fun createRecipe(recipes: List<Recipe>) {
        repository.insertRecipes(recipes)
    }
}