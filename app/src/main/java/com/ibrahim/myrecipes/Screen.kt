package com.ibrahim.myrecipes

sealed class Screen(val route: String){
    data object HomeScreen: Screen(route = "home_screen")
    data object RecipeTitle: Screen(route = "recipe_title")
    data object RecipeImage: Screen(route = "recipe_image")
    data object RecipeCategory: Screen(route = "recipe_category")
    data object RecipeIngredients: Screen(route = "recipe_ingredients")
    data object RecipeInstructions: Screen(route = "recipe_instructions")
    data object RecipeDetail: Screen(route = "recipe_detail")
}
