package com.ibrahim.myrecipes.presentation.recipedetail.viewmodel

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.Ingredients

data class RecipeDetailState(
    val recipe: Recipe = Recipe(
        0L,
        "",
        "",
        listOf(""),
        0,
        0,
        FoodCategory.BURGER,
        ""
    ),
    val ingredients: Ingredients = listOf(),
    val isFirstLaunch: Boolean = false
)
