package com.ibrahim.myrecipes.domain.usecase.recipe

import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRecipesUseCase  @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    fun filterRecipes(query: String): Flow<List<Recipe>>? {
        return recipeRepository.searchRecipe(query)
    }
}