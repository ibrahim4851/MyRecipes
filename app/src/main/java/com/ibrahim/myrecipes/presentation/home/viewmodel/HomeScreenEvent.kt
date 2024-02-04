package com.ibrahim.myrecipes.presentation.home.viewmodel

import com.ibrahim.myrecipes.data.enums.FoodCategory

sealed class HomeScreenEvent {
    data class SearchFoodsByTitleAndIngredient(val query: String = ""): HomeScreenEvent()

    data class FilterFoodsByCategory(val categories: List<FoodCategory> = mutableListOf<FoodCategory>()): HomeScreenEvent()

    data class ResetCategoryFilter(val dummy: String = ""): HomeScreenEvent()

}