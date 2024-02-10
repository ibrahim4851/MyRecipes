package com.ibrahim.myrecipes.presentation.home.ui

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibrahim.myrecipes.domain.model.Recipe

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipesStaggeredGrid(
    recipes: List<Recipe> = dummyRecipeList,
    onRecipeItemClick: (Recipe) -> Unit,
    onDeleteClick: (Recipe) -> Unit
){

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(150.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalItemSpacing = 4.dp
    ){
        items(recipes.size) { itemIndex ->
            RecipeItem(
                recipes[itemIndex],
                onRecipeItemClick = onRecipeItemClick,
                onDeleteClick = onDeleteClick,
                modifier = Modifier.animateItemPlacement(animationSpec = tween(
                    durationMillis = 600
                ))
            )
        }
    }
}