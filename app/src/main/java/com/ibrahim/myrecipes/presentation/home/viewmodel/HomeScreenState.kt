package com.ibrahim.myrecipes.presentation.home.viewmodel

import com.ibrahim.myrecipes.domain.model.Recipe

data class HomeScreenState(
    val recipes: List<Recipe> = listOf(),
    val permissionNotGrantedMessage: String = ""
)
