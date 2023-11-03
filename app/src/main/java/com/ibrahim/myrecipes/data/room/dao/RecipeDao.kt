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
    fun insertRecipe(recipeEntity: RecipeEntity): Long

    @Delete
    fun deleteRecipe(recipeEntity: RecipeEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRecipe(recipeEntity: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngredient(ingredientEntity: IngredientEntity): Long

    @Delete
    fun deleteIngredient(ingredientEntity: IngredientEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateIngredient(ingredientEntity: IngredientEntity)

    @Query("SELECT * FROM ingredients")
    fun getAllIngredients(): Flow<List<IngredientEntity>>

    @Transaction
    @Query("SELECT * FROM recipes WHERE recipeId = :recipeId")
    fun getRecipeWithIngredients(recipeId: Int): Flow<RecipeIngredients?>


    @Query(
        "SELECT DISTINCT r.* FROM recipes r " +
                "LEFT JOIN ingredients i ON r.recipeId = i.recipeId " +
                "WHERE r.recipeTitle LIKE '%' || :query || '%' " +
                "OR i.ingredientName LIKE '%' || :query || '%'"
    )
    fun searchRecipes(query: String): Flow<List<RecipeEntity>>

    @Transaction
    @Query("SELECT * FROM recipes WHERE foodCategory = :foodCategory")
    fun getRecipesByFoodType(foodCategory: FoodCategory): Flow<List<RecipeEntity>>


}