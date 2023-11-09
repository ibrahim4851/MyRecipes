package com.ibrahim.myrecipes.presentation.navigation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibrahim.myrecipes.CheckExternalStoragePermission
import com.ibrahim.myrecipes.CheckPermissionTiramisu
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.home.HomeScreen
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.AddRecipeImage
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.RecipeTitle
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.SetCategory
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.SetIngredients
import com.ibrahim.myrecipes.presentation.recipe.createrecipe.SetInstructions

@Composable
fun ScreensNavigation(){
    val navController = rememberNavController()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        CheckPermissionTiramisu()
    } else {
        CheckExternalStoragePermission()
    }

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.RecipeTitle.route) {
            RecipeTitle(navController = navController)
        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.RecipeImage.route) {
            AddRecipeImage(navController = navController)
        }

        composable(route = Screen.RecipeCategory.route) {
            SetCategory(navController = navController)
        }

        composable(route = Screen.RecipeIngredients.route) {
            SetIngredients(navController = navController)
        }

        composable(route = Screen.RecipeInstructions.route) {
            SetInstructions(navController = navController)
        }

    }
}