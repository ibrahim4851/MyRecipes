package com.ibrahim.myrecipes.domain.usecase.recipe

import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    fun getRecipes(): Flow<List<Recipe>> {
        return repository.getAllRecipes()
    }

}