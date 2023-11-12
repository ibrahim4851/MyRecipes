package com.ibrahim.myrecipes.domain.repository

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

typealias Recipes = List<Recipe>
typealias Ingredients = List<Ingredient>
interface RecipeRepository {

    fun getAllRecipes(): Flow<Recipes>

    suspend fun insertRecipe(recipe: Recipe): Long

    suspend fun insertIngredients(ingredients: Ingredients)

    suspend fun updateRecipe(recipe: Recipe)

    suspend fun updateIngredient(ingredient: Ingredient)

    suspend fun deleteRecipe(recipe: Recipe)

    suspend fun deleteIngredient(ingredient: Ingredient)

    suspend fun getAllIngredients(): Ingredients

    suspend fun searchRecipe(query: String): Recipes

    suspend fun filterRecipe(foodCategory: FoodCategory): Recipes

}