package com.ibrahim.myrecipes.presentation.navigation

import android.os.Build
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ibrahim.myrecipes.CheckExternalStoragePermission
import com.ibrahim.myrecipes.CheckPermissionTiramisu
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.home.ui.HomeScreen
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

            composable(route = Screen.RecipeImage.route,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                }) {
                AddRecipeImage(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable(route = Screen.RecipeCategory.route,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                }) {
                SetCategory(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable(route = Screen.RecipeIngredients.route,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                }) {
                SetIngredients(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable(route = Screen.RecipeInstructions.route,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                }) {
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