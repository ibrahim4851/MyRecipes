package com.ibrahim.myrecipes.presentation.home.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.presentation.home.viewmodel.HomeScreenEvent
import com.ibrahim.myrecipes.presentation.home.viewmodel.HomeViewModel
import com.ibrahim.myrecipes.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var expandSearchBar by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    },
                    actions = {
                        IconButton(onClick = { expandSearchBar = !expandSearchBar }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = null
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.navigate("create_recipe")
                    }
                ) {
                    Icon(Icons.Filled.Add, null)
                }
            }
        ) { values ->
            Column(
                modifier = Modifier
                    .padding(values)
                    .padding(start = 0.dp, end = 0.dp)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        RoundedCornerShape(topStart = 36.dp)
                    )
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(keyframes {
                        durationMillis = 200
                    }
                    )
                ) {
                    if (expandSearchBar) {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchValue ->
                                searchQuery = searchValue
                                viewModel.onEvent(
                                    HomeScreenEvent.SearchFoodsByTitleAndIngredient(
                                        searchQuery
                                    )
                                )
                            },
                            Modifier
                                .fillMaxWidth()
                                .widthIn(max = 400.dp)
                                .padding(top = 12.dp, start = 12.dp, end = 12.dp),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Search,
                                    contentDescription = null
                                )
                            },
                            placeholder = {
                                Text(text = stringResource(R.string.search_for_your_food))
                            }
                        )
                    }
                }
                MyChipGroup(onChipSelected = { selectedCategories ->
                    if (selectedCategories.isEmpty()) {
                        viewModel.onEvent(HomeScreenEvent.ResetCategoryFilter())
                    } else {
                        viewModel.onEvent(HomeScreenEvent.FilterFoodsByCategory(selectedCategories))
                    }
                })
                RecipesStaggeredGrid(
                    viewModel.state.value.gridItems,
                    onRecipeItemClick = { recipe ->
                        navController.navigate(Screen.RecipeDetail.route + "/" + recipe.recipeId)
                    },
                    onDeleteClick = { recipe ->
                        viewModel.onEvent(HomeScreenEvent.DeleteRecipe(recipeId = recipe.recipeId))
                    }
                )
            }
        }
    }
}