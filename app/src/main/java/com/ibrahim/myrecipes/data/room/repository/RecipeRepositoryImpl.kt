package com.ibrahim.myrecipes.data.room.repository

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.room.dao.RecipeDao
import com.ibrahim.myrecipes.data.room.mapper.toIngredient
import com.ibrahim.myrecipes.data.room.mapper.toIngredientEntity
import com.ibrahim.myrecipes.data.room.mapper.toRecipe
import com.ibrahim.myrecipes.data.room.mapper.toRecipeEntity
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.Ingredients
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import com.ibrahim.myrecipes.domain.repository.Recipes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepositoryImpl(private val dao: RecipeDao) : RecipeRepository {

    override fun getAllRecipes(): Flow<Recipes> {
        return dao.getAllRecipes().map { recipeEntities ->
            recipeEntities.map { it.toRecipe() }
        }
    }

    override suspend fun insertRecipes(recipes: Recipes) {
        recipes.map { it.toRecipeEntity() }.forEach {
            dao.insertRecipe(it)
        }
    }

    override suspend fun insertIngredients(ingredients: Ingredients) {
        ingredients.map { it.toIngredientEntity() }.forEach {
            dao.insertIngredient(it)
        }
    }

    override suspend fun updateRecipe(recipe: Recipe) {
        dao.updateRecipe(recipe.toRecipeEntity())
    }

    override suspend fun updateIngredient(ingredient: Ingredient) {
        dao.updateIngredient(ingredient.toIngredientEntity())
    }

    override suspend fun deleteRecipe(recipe: Recipe) {
        dao.deleteRecipe(recipe.toRecipeEntity())
    }

    override suspend fun deleteIngredient(ingredient: Ingredient) {
        dao.deleteIngredient(ingredient.toIngredientEntity())
    }


    override suspend fun getAllIngredients(): Ingredients {
        return dao.getAllIngredients().map {
                ingredientEntity -> ingredientEntity.toIngredient() }
    }

    override suspend fun searchRecipe(query: String): Recipes {
        return dao.searchRecipes(query).map { recipeEntity ->
            recipeEntity.toRecipe()  }
    }

    override suspend fun filterRecipe(foodCategory: FoodCategory): Recipes {
        return dao.getRecipesByFoodType(foodCategory).map { recipeEntity ->
            recipeEntity.toRecipe()
        }
    }
}