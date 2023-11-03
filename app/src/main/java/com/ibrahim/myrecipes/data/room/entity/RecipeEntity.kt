package com.ibrahim.myrecipes.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ibrahim.myrecipes.data.enums.FoodCategory

@Entity(tableName = "recipes")
data class RecipeEntity (

    @PrimaryKey(autoGenerate = true) val recipeId: Long,
    val recipeTitle: String,
    val recipeDescription: String,
    val recipeInstructions: String,
    val recipeTime: Int,
    val recipeServings: Int,
    val recipePhotoUri: String?,
    val foodCategory: FoodCategory,
)