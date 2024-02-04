package com.ibrahim.myrecipes.presentation.home.viewmodel

sealed class HomeScreenEvent {
    data class SearchFoodsByTitleAndIngredient(val query: String = ""): HomeScreenEvent()

}