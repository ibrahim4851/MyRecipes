package com.ibrahim.myrecipes.domain.usecase.ingredient

import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetIngredientUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    fun getRecipes(): Flow<List<Ingredient>>? {
        return repository.getAllIngredients()
    }

}