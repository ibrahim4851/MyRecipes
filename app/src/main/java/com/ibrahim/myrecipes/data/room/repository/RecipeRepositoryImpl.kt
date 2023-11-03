package com.ibrahim.myrecipes.data.room.repository

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.room.dao.RecipeDao
import com.ibrahim.myrecipes.data.room.mapper.toIngredient
import com.ibrahim.myrecipes.data.room.mapper.toIngredientEntity
import com.ibrahim.myrecipes.data.room.mapper.toRecipe
import com.ibrahim.myrecipes.data.room.mapper.toRecipeEntity
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepositoryImpl(private val dao: RecipeDao) : RecipeRepository {

    override fun insertRecipes(recipes: List<Recipe>) {
        recipes.map { it.toRecipeEntity() }.forEach {
            dao.insertRecipe(it)
        }
    }

    override fun insertIngredients(ingredients: List<Ingredient>) {
        ingredients.map { it.toIngredientEntity() }.forEach {
            dao.insertIngredient(it)
        }
    }

    override fun updateRecipe(recipe: Recipe) {
        dao.updateRecipe(recipe.toRecipeEntity())
    }

    override fun updateIngredient(ingredient: Ingredient) {
        dao.updateIngredient(ingredient.toIngredientEntity())
    }

    override fun deleteRecipe(recipe: Recipe) {
        dao.deleteRecipe(recipe.toRecipeEntity())
    }

    override fun deleteIngredient(ingredient: Ingredient) {
        dao.deleteIngredient(ingredient.toIngredientEntity())
    }

    override fun getAllRecipes(): Flow<List<Recipe>> {
        return dao.getAllRecipes().map { entities -> entities.map { it.toRecipe() } }
    }

    override fun getAllIngredients(): Flow<List<Ingredient>> {
        return dao.getAllIngredients().map { entities ->
            entities.map { it.toIngredient() }
        }
    }

    override fun searchRecipe(query: String): Flow<List<Recipe>> {
        return dao.searchRecipes(query).map { entities -> entities.map { it.toRecipe() } }
    }

    override fun filterRecipe(foodCategory: FoodCategory): Flow<List<Recipe>> {
        return dao.getRecipesByFoodType(foodCategory).map { entities ->
            entities.map { it.toRecipe() }
        }
    }
}