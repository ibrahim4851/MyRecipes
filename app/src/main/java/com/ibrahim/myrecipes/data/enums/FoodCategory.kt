package com.ibrahim.myrecipes.data.enums

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalContext
import com.ibrahim.myrecipes.R

@Stable
enum class FoodCategory(val resourceId: Int) {
    BURGER(R.string.food_category_burger),
    PIZZA(R.string.food_category_pizza),
    PASTA(R.string.food_category_pasta),
    SALAD(R.string.food_category_salad),
    DESSERT(R.string.food_category_dessert),
    SOUP(R.string.food_category_soup),
    VEGETABLE(R.string.food_category_vegetable),
    SANDWICH(R.string.food_category_sandwich),
    LEGUMES(R.string.food_category_legumes),
    BREAKFAST(R.string.food_category_breakfast),
    BEVERAGE(R.string.food_category_beverage),
    SUSHI(R.string.food_category_sushi),
    STEAK(R.string.food_category_steak),
    SEAFOOD(R.string.food_category_seafood),
    CHICKEN(R.string.food_category_chicken),
    VEGETARIAN(R.string.food_category_vegetarian),
    BBQ(R.string.food_category_barbecue),
    OTHER(R.string.food_category_other);
}

@Stable
fun getAllFoodCategories(): List<FoodCategory> {
    return listOf(
        FoodCategory.BURGER,
        FoodCategory.PIZZA,
        FoodCategory.PASTA,
        FoodCategory.SALAD,
        FoodCategory.DESSERT,
        FoodCategory.SOUP,
        FoodCategory.VEGETABLE,
        FoodCategory.SANDWICH,
        FoodCategory.LEGUMES,
        FoodCategory.BREAKFAST,
        FoodCategory.BEVERAGE,
        FoodCategory.SUSHI,
        FoodCategory.STEAK,
        FoodCategory.SEAFOOD,
        FoodCategory.CHICKEN,
        FoodCategory.VEGETARIAN,
        FoodCategory.BBQ,
        FoodCategory.OTHER,
    )
}

@Composable
@Stable
fun FoodCategory.getLabel(): String {
    val context = LocalContext.current
    return context.getString(this.resourceId)
}

