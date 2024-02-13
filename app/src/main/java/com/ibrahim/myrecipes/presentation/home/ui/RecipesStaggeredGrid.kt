package com.ibrahim.myrecipes.presentation.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.domain.model.Recipe

@Composable
fun RecipesStaggeredGrid(
    items: List<GridItem>,
    onRecipeItemClick: (Recipe) -> Unit,
    onDeleteClick: (Recipe) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(150.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalItemSpacing = 4.dp
    ) {
        items(items, key = {
            when (it) {
                is GridItem.RecipeItem -> it.recipe.recipeId
                is GridItem.AdItem -> it.adId
            }
        }) { item ->
            when (item) {
                is GridItem.RecipeItem -> {
                    RecipeItem(
                        recipe = item.recipe,
                        onRecipeItemClick = onRecipeItemClick,
                        onDeleteClick = onDeleteClick,
                        modifier = Modifier
                    )
                }
                is GridItem.AdItem -> {
                    NativeAdComposable(modifier = Modifier.fillMaxSize(), adUnitId = stringResource(id = R.string.ADMOB_AD_KEY))
                }
            }
        }
    }
}
