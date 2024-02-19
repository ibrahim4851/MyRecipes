package com.ibrahim.myrecipes.presentation.navigation

import android.content.Context
import android.os.Build
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ibrahim.myrecipes.util.CheckExternalStoragePermission
import com.ibrahim.myrecipes.util.CheckPermissionTiramisu
import com.ibrahim.myrecipes.presentation.createrecipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.createrecipe.ui.AddRecipeImage
import com.ibrahim.myrecipes.presentation.createrecipe.ui.RecipeTitle
import com.ibrahim.myrecipes.presentation.createrecipe.ui.SetCategory
import com.ibrahim.myrecipes.presentation.createrecipe.ui.SetIngredients
import com.ibrahim.myrecipes.presentation.createrecipe.ui.SetInstructions
import com.ibrahim.myrecipes.presentation.home.ui.HomeScreen
import com.ibrahim.myrecipes.presentation.onboarding.ui.OnBoardingScreen
import com.ibrahim.myrecipes.presentation.recipedetail.ui.RecipeDetail

@Composable
fun ScreensNavigation() {
    val navController = rememberNavController()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        CheckPermissionTiramisu()
    } else {
        CheckExternalStoragePermission()
    }

    val viewModel: RecipeViewModel = hiltViewModel()
    val context = LocalContext.current
    val startDestination =
        if (isFirstRun(context)) Screen.OnBoardingScreen.route else Screen.HomeScreen.route

    NavHost(navController = navController, startDestination = startDestination) {

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

        composable(route = Screen.RecipeDetail.route + "/{recipeId}") {
            RecipeDetail(navController = navController)
        }


        composable(route = Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }


    }
}


fun isFirstRun(context: Context): Boolean {
    val sharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)
    if (isFirstRun) {
        with(sharedPreferences.edit()) {
            putBoolean("isFirstRun", false)
            apply()
        }
    }
    return isFirstRun
}


