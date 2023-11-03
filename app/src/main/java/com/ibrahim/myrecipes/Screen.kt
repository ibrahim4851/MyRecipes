package com.ibrahim.myrecipes

sealed class Screen(val route: String){
    object HomeScreen: Screen(route = "home_screen")
    object RecipeTitle: Screen(route = "recipe_title")
    object RecipeImage: Screen(route = "recipe_image")
    object RecipeCategory: Screen(route = "recipe_category")
    object RecipeIngredients: Screen(route = "recipe_ingredients")
    object RecipeInstructions: Screen(route = "recipe_instructions")
    object RecipeServingsAndTime: Screen(route = "recipe_servings_and_time")
}
