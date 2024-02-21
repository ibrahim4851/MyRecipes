package com.ibrahim.myrecipes.presentation.home.ui

import androidx.compose.runtime.Immutable
import com.ibrahim.myrecipes.domain.model.Recipe
import java.util.UUID

@Immutable
sealed class GridItem {
    @Immutable data class RecipeItem(val recipe: Recipe) : GridItem()
    @Immutable data class AdItem(val adId: UUID) : GridItem()
}
