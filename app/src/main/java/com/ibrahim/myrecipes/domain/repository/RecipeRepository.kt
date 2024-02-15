package com.ibrahim.myrecipes.domain.repository

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.room.entity.IngredientEntity
import com.ibrahim.myrecipes.data.room.entity.RecipeEntity
import com.ibrahim.myrecipes.data.room.entity.RecipeIngredients
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

typealias Recipes = List<Recipe>
typealias Ingredients = List<Ingredient>
interface RecipeRepository {

    fun getAllRecipes(): Flow<Recipes>

    suspend fun insertRecipe(recipe: Recipe): Long

    suspend fun insertAllRecipes(recipeEntities: List<RecipeEntity>)

    suspend fun insertIngredients(ingredients: Ingredients)

    suspend fun updateRecipe(recipe: Recipe)

    suspend fun updateIngredient(ingredient: Ingredient)

    suspend fun deleteRecipe(recipeId: Long)

    suspend fun deleteIngredient(ingredientId: Long)

    suspend fun insertAllIngredients(ingredientEntities: List<IngredientEntity>)

    suspend fun getAllIngredients(): Ingredients

    suspend fun searchRecipe(query: String): Recipes

    suspend fun getRecipesByFoodType(foodCategories: List<FoodCategory>): Recipes

    suspend fun getRecipeWithIngredients(recipeId: Int): RecipeIngredients

}