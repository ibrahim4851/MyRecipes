package com.ibrahim.myrecipes.presentation.home.viewmodel

import androidx.compose.runtime.Immutable
import com.ibrahim.myrecipes.presentation.home.ui.GridItem

@Immutable
data class HomeScreenState(
    val gridItems: List<GridItem> = listOf(),
    val permissionNotGrantedMessage: String = ""
)
