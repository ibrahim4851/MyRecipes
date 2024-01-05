package com.ibrahim.myrecipes.domain.model

import android.os.Parcelable
import com.ibrahim.myrecipes.data.enums.FoodCategory
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val recipeId: Long,
    val recipeTitle: String,
    val recipeDescription: String,
    val recipeInstructions: List<String>,
    val recipeTime: Int,
    val recipeServings: Int,
    val foodCategory: FoodCategory,
    val recipePhotoUri: String?
): Parcelable