package com.ibrahim.myrecipes.data.enums

enum class FoodCategory(val value: String) {
    BURGER("Burger"),
    PIZZA("Pizza"),
    PASTA("Pasta"),
    SALAD("Salad"),
    DESSERT("Dessert"),
    SOUP("Soup"),
    SANDWICH("Sandwich"),
    BREAKFAST("Breakfast"),
    BEVERAGE("Beverage"),
    SUSHI("Sushi"),
    STEAK("Steak"),
    SEAFOOD("Seafood"),
    CHICKEN("Chicken"),
    VEGETARIAN("Vegetarian"),
    BBQ("Barbecue"),
    OTHER("Other"),
}

fun getAllFoodCategories(): List<FoodCategory> {
    return listOf(
        FoodCategory.BURGER,
        FoodCategory.PIZZA,
        FoodCategory.PASTA,
        FoodCategory.SALAD,
        FoodCategory.DESSERT,
        FoodCategory.SOUP,
        FoodCategory.SANDWICH,
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

fun getFoodCategory(value: String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}
