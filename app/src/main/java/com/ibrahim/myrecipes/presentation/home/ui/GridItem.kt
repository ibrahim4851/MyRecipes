package com.ibrahim.myrecipes.presentation.home.ui

import com.ibrahim.myrecipes.domain.model.Recipe
import java.util.UUID

sealed class GridItem {
    data class RecipeItem(val recipe: Recipe) : GridItem()
    data class AdItem(val adId: UUID) : GridItem()
}
