package com.ibrahim.myrecipes.presentation.editrecipe.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.presentation.createrecipe.ui.CategorySelector
import com.ibrahim.myrecipes.presentation.editrecipe.viewmodel.EditRecipeViewModel

@Composable
fun EditRecipeScreen(
    navController: NavController,
    viewModel: EditRecipeViewModel = hiltViewModel()
) {

    val recipe = viewModel.state.value.recipe
    val ingredients = viewModel.state.value.ingredients

    var recipeTitle by remember { mutableStateOf(recipe.recipeTitle) }
    var recipeServings by remember { mutableStateOf(recipe.recipeServings.toString()) }
    var recipeTime by remember { mutableStateOf(recipe.recipeTime.toString()) }
    var recipeCategory by remember { mutableStateOf(recipe.foodCategory) }
    var recipeInstructions by remember { mutableStateOf(recipe.recipeInstructions) }
    var recipePhotoUri by remember { mutableStateOf(recipe.recipePhotoUri) }

    val selectedChipState = remember { mutableStateMapOf<FoodCategory, Boolean>(Pair(recipeCategory, true)) }
    val isChipSelected = remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                OutlinedTextField(value = recipeTitle, onValueChange = { recipeTitle = it })
                Spacer(Modifier.size(8.dp))
                OutlinedTextField(
                    value = recipeServings,
                    onValueChange = { recipeServings = it })
                Spacer(Modifier.size(8.dp))
                OutlinedTextField(value = recipeTime, onValueChange = { recipeTime = it })
                Spacer(Modifier.size(8.dp))
                CategorySelector(selectedChipState = selectedChipState, isChipSelected = isChipSelected)
                Spacer(Modifier.size(8.dp))
            }
        }
    }
}