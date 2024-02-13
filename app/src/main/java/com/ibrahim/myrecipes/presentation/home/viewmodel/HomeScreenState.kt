package com.ibrahim.myrecipes.presentation.home.viewmodel

import com.ibrahim.myrecipes.presentation.home.ui.GridItem

data class HomeScreenState(
    val gridItems: List<GridItem> = listOf(),
    val permissionNotGrantedMessage: String = ""
)
