package com.ibrahim.myrecipes.presentation.editrecipe.viewmodel

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.Ingredients

data class EditRecipeState(
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
    val ingredients: Ingredients = listOf()
)
