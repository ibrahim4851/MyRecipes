package com.ibrahim.myrecipes.presentation.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    init {
        getRecipes()
    }

    private fun getRecipes() = viewModelScope.launch {
        repository.getAllRecipes().onEach {
            _state.value = HomeScreenState(recipes = it)
        }.launchIn(viewModelScope)
    }

    private fun searchFoodsByTitleAndIngredient(query: String) = viewModelScope.launch {
        _state.value = HomeScreenState(recipes = repository.searchRecipe(query))
    }

    private fun filterFoodsByCategory(categories: List<FoodCategory>) = viewModelScope.launch {
        _state.value = HomeScreenState(recipes = repository.getRecipesByFoodType(categories))
    }

    private fun deleteRecipe(recipeId: Long) = viewModelScope.launch {
        repository.deleteRecipe(recipeId)
    }

    fun onEvent(event: HomeScreenEvent) {
        when(event) {
            is HomeScreenEvent.SearchFoodsByTitleAndIngredient -> {
                searchFoodsByTitleAndIngredient(event.query)
            }

            is HomeScreenEvent.FilterFoodsByCategory -> {
                filterFoodsByCategory(event.categories)
            }

            is HomeScreenEvent.ResetCategoryFilter -> {
                getRecipes()
            }

            is HomeScreenEvent.DeleteRecipe -> {
                deleteRecipe(event.recipeId)
            }
        }
    }
}