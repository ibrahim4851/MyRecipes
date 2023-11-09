package com.ibrahim.myrecipes.presentation.recipe

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Recipe

data class CreateRecipeState(
    val recipe: Recipe = Recipe(
        0L,
        "",
        "",
        "",
        0,
        0,
        FoodCategory.BURGER,
        ""
        )
)
