package com.ibrahim.myrecipes.presentation.home

import androidx.lifecycle.ViewModel
import com.ibrahim.myrecipes.domain.usecase.recipe.FilterRecipesUseCase
import com.ibrahim.myrecipes.domain.usecase.recipe.GetRecipesUseCase
import com.ibrahim.myrecipes.domain.usecase.recipe.SearchRecipesUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase,
    private val filterRecipesUseCase: FilterRecipesUseCase,
    private val searchRecipesUseCase: SearchRecipesUseCase
): ViewModel() {
}