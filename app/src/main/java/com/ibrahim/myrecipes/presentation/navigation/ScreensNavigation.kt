package com.ibrahim.myrecipes.presentation.navigation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ibrahim.myrecipes.CheckExternalStoragePermission
import com.ibrahim.myrecipes.CheckPermissionTiramisu
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.home.HomeScreen
import com.ibrahim.myrecipes.presentation.recipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.AddRecipeImage
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.RecipeTitle
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.SetCategory
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.SetIngredients
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.SetInstructions

@Composable
fun ScreensNavigation() {
    val navController = rememberNavController()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        CheckPermissionTiramisu()
    } else {
        CheckExternalStoragePermission()
    }

    val viewModel: RecipeViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        navigation(startDestination = Screen.RecipeTitle.route, route = "create_recipe") {

            composable(route = Screen.RecipeTitle.route) {
                RecipeTitle(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable(route = Screen.RecipeImage.route) {
                AddRecipeImage(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable(route = Screen.RecipeCategory.route) {
                SetCategory(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable(route = Screen.RecipeIngredients.route) {
                SetIngredients(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable(route = Screen.RecipeInstructions.route) {
                SetInstructions(
                    navController = navController,
                    viewModel = viewModel
                )
            }

        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navHostController: NavHostController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navHostController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}