package com.ibrahim.myrecipes.presentation.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import com.ibrahim.myrecipes.presentation.home.ui.GridItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    private val _uiEffect = MutableSharedFlow<HomeUiEffect>()
    val uiEffect: SharedFlow<HomeUiEffect> = _uiEffect.asSharedFlow()

    init {
        getRecipes()
    }

    private fun getRecipes() = viewModelScope.launch {
        repository.getAllRecipes().onEach { recipes ->
            val mixedItems = mutableListOf<GridItem>()
            recipes.forEachIndexed { index, recipe ->
                mixedItems.add(GridItem.RecipeItem(recipe))
                if ((index + 1) % 3 == 0) {
                    mixedItems.add(GridItem.AdItem(UUID.randomUUID()))
                }
            }
            _state.value = HomeScreenState(gridItems = mixedItems)
        }.launchIn(viewModelScope)
    }


    private fun searchFoodsByTitleAndIngredient(query: String) = viewModelScope.launch {
        val searchResults = repository.searchRecipe(query)
        val mixedItems = mixRecipesWithAds(searchResults)
        _state.value = HomeScreenState(gridItems = mixedItems)
    }

    private fun filterFoodsByCategory(categories: List<FoodCategory>) = viewModelScope.launch {
        val filterResults = repository.getRecipesByFoodType(categories)
        val mixedItems = mixRecipesWithAds(filterResults)
        _state.value = HomeScreenState(gridItems = mixedItems)
    }

    private fun mixRecipesWithAds(recipes: List<Recipe>): List<GridItem> {
        val mixedItems = mutableListOf<GridItem>()
        recipes.forEachIndexed { index, recipe ->
            mixedItems.add(GridItem.RecipeItem(recipe))
            if ((index + 1) % 3 == 0) {
                mixedItems.add(GridItem.AdItem(adId = UUID.randomUUID()))
            }
        }
        return mixedItems
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

            is HomeScreenEvent.UpdateLanguage -> {
                viewModelScope.launch {
                    _uiEffect.emit(HomeUiEffect.ChangeLanguage(event.languageCode))
                }
            }
        }
    }
}