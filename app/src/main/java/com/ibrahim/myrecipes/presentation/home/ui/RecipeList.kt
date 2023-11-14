package com.ibrahim.myrecipes.presentation.home.ui

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Recipe

val dummyRecipeList = listOf(
    Recipe(
        recipeId = 1,
        recipeTitle = "Classic Margherita Pizza",
        recipeDescription = "A simple and classic Margherita pizza recipe",
        recipeInstructions = "1. Preheat the oven...\n2. Roll out the pizza dough...\n3. Add tomato sauce...",
        recipeTime = 45,
        recipeServings = 4,
        foodCategory = FoodCategory.PIZZA,
        recipePhotoUri = "/storage/emulated/0/DCIM/MargheritaPizza.jpeg"
    ),
    Recipe(
        recipeId = 2,
        recipeTitle = "Spaghetti Carbonara",
        recipeDescription = "A creamy and delicious spaghetti carbonara recipe",
        recipeInstructions = "1. Cook spaghetti...\n2. Fry pancetta...\n3. Whisk eggs and cheese...",
        recipeTime = 30,
        recipeServings = 2,
        foodCategory = FoodCategory.PASTA,
        recipePhotoUri = "/storage/emulated/0/DCIM/carbonara.jpeg"
    ),
    Recipe(
        recipeId = 3,
        recipeTitle = "Caesar Salad",
        recipeDescription = "A classic Caesar salad with homemade dressing",
        recipeInstructions = "1. Prepare lettuce...\n2. Make Caesar dressing...\n3. Toss salad...",
        recipeTime = 15,
        recipeServings = 2,
        foodCategory = FoodCategory.SALAD,
        recipePhotoUri = "/storage/emulated/0/DCIM/caesar.jpeg"
    ),
    Recipe(
        recipeId = 4,
        recipeTitle = "Chocolate Brownies",
        recipeDescription = "Rich and fudgy chocolate brownies",
        recipeInstructions = "1. Preheat the oven...\n2. Melt chocolate and butter...\n3. Bake brownies...",
        recipeTime = 40,
        recipeServings = 8,
        foodCategory = FoodCategory.DESSERT,
        recipePhotoUri = "/storage/emulated/0/DCIM/brownies.jpeg"
    ),
    Recipe(
        recipeId = 5,
        recipeTitle = "Minestrone Soup",
        recipeDescription = "A hearty and healthy minestrone soup",
        recipeInstructions = "1. Saute onions and garlic...\n2. Add vegetables and broth...\n3. Simmer the soup...",
        recipeTime = 35,
        recipeServings = 6,
        foodCategory = FoodCategory.SOUP,
        recipePhotoUri = "/storage/emulated/0/DCIM/minestrone.jpeg"
    ),
    Recipe(
        recipeId = 6,
        recipeTitle = "Turkey Club Sandwich",
        recipeDescription = "A classic turkey club sandwich with bacon and avocado",
        recipeInstructions = "1. Toast bread...\n2. Layer turkey, bacon, and avocado...\n3. Assemble sandwich...",
        recipeTime = 15,
        recipeServings = 2,
        foodCategory = FoodCategory.SANDWICH,
        recipePhotoUri = "/storage/emulated/0/DCIM/turkeysandwich.jpeg"
    ),
    Recipe(
        recipeId = 7,
        recipeTitle = "Blueberry Pancakes",
        recipeDescription = "Fluffy and delicious blueberry pancakes",
        recipeInstructions = "1. Mix pancake batter...\n2. Add blueberries...\n3. Cook pancakes...",
        recipeTime = 20,
        recipeServings = 4,
        foodCategory = FoodCategory.BREAKFAST,
        recipePhotoUri = "/storage/emulated/0/DCIM/blueberyrypanck.jpeg"
    )
)
