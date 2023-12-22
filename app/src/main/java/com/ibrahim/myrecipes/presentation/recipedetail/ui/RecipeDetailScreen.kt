package com.ibrahim.myrecipes.presentation.recipedetail.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ibrahim.myrecipes.presentation.recipedetail.viewmodel.RecipeDetailViewModel

@Composable
fun RecipeDetailScreen(
    navController: NavController,
    viewModel: RecipeDetailViewModel = hiltViewModel()
) {

    val screenWidth: Int = LocalConfiguration.current.screenWidthDp

    Surface(modifier = Modifier.fillMaxSize()) {

    }
}

@Preview
@Composable
fun DetailPreview() {
    RecipeDetailScreen(navController = rememberNavController())
}