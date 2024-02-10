package com.ibrahim.myrecipes.data.room.repository

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.room.dao.RecipeDao
import com.ibrahim.myrecipes.data.room.entity.IngredientEntity
import com.ibrahim.myrecipes.data.room.entity.RecipeEntity
import com.ibrahim.myrecipes.data.room.entity.RecipeIngredients
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

    override suspend fun insertRecipe(recipe: Recipe): Long {
        return dao.insertRecipe(recipe.toRecipeEntity())
    }

    override suspend fun insertAllRecipes(recipeEntities: List<RecipeEntity>) {
        dao.insertAllRecipes(recipeEntities)
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

    override suspend fun deleteRecipe(recipeId: Long) {
        dao.deleteRecipe(recipeId)
    }

    override suspend fun deleteIngredient(ingredient: Ingredient) {
        dao.deleteIngredient(ingredient.toIngredientEntity())
    }


    override suspend fun getAllIngredients(): Ingredients {
        return dao.getAllIngredients().map { ingredientEntity -> ingredientEntity.toIngredient() }
    }

    override suspend fun searchRecipe(query: String): Recipes {
        return dao.searchRecipes(query).map { recipeEntity ->
            recipeEntity.toRecipe()
        }
    }

    override suspend fun insertAllIngredients(ingredientEntities: List<IngredientEntity>) {
        dao.insertAllIngredients(ingredientEntities)
    }

    override suspend fun getRecipesByFoodType(foodCategories: List<FoodCategory>): Recipes {
        return dao.getRecipesByFoodType(foodCategories).map { recipeEntity ->
            recipeEntity.toRecipe()
        }
    }

    override suspend fun getRecipeWithIngredients(recipeId: Int): RecipeIngredients {
        return dao.getRecipeWithIngredients(recipeId)!!
    }

}