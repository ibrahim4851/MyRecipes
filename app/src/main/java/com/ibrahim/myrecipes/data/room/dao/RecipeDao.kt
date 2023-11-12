package com.ibrahim.myrecipes.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.room.entity.IngredientEntity
import com.ibrahim.myrecipes.data.room.entity.RecipeEntity
import com.ibrahim.myrecipes.data.room.entity.RecipeIngredients
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipes")
    fun getAllRecipes(): Flow<List<RecipeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipeEntity: RecipeEntity): Long

    @Delete
    suspend fun deleteRecipe(recipeEntity: RecipeEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateRecipe(recipeEntity: RecipeEntity)

    @Transaction
    @Query("SELECT * FROM recipes WHERE recipeId = :recipeId")
    suspend fun getRecipeWithIngredients(recipeId: Int): RecipeIngredients?


    @Query(
        "SELECT DISTINCT r.* FROM recipes r " +
                "LEFT JOIN ingredients i ON r.recipeId = i.ownerRecipeId " +
                "WHERE r.recipeTitle LIKE '%' || :query || '%' " +
                "OR i.ingredientName LIKE '%' || :query || '%'"
    )
    suspend fun searchRecipes(query: String): List<RecipeEntity>

    @Transaction
    @Query("SELECT * FROM recipes WHERE foodCategory = :foodCategory")
    suspend fun getRecipesByFoodType(foodCategory: FoodCategory): List<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredient(ingredientEntity: IngredientEntity): Long

    @Delete
    suspend fun deleteIngredient(ingredientEntity: IngredientEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateIngredient(ingredientEntity: IngredientEntity)

    @Query("SELECT * FROM ingredients")
    suspend fun getAllIngredients(): List<IngredientEntity>




}