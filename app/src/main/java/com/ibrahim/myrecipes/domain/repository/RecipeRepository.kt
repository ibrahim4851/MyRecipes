package com.ibrahim.myrecipes.domain.repository

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    fun insertRecipes(recipes: List<Recipe>)

    fun insertIngredients(ingredients: List<Ingredient>)

    fun updateRecipe(recipe: Recipe)

    fun updateIngredient(ingredient: Ingredient)

    fun deleteRecipe(recipe: Recipe)

    fun deleteIngredient(ingredient: Ingredient)

    fun getAllRecipes(): Flow<List<Recipe>>

    fun getAllIngredients(): Flow<List<Ingredient>>

    fun searchRecipe(query: String): Flow<List<Recipe>>

    fun filterRecipe(foodCategory: FoodCategory): Flow<List<Recipe>>

}