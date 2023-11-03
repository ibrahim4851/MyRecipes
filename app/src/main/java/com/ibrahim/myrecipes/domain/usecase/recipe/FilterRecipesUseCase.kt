package com.ibrahim.myrecipes.domain.usecase.recipe

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilterRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    fun filterRecipes(type: FoodCategory): Flow<List<Recipe>>? {
        return recipeRepository.filterRecipe(type)
    }
}