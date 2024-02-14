package com.ibrahim.myrecipes.presentation.recipedetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.room.mapper.toIngredient
import com.ibrahim.myrecipes.data.room.mapper.toRecipe
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val repository: RecipeRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(RecipeDetailState())
    val state: State<RecipeDetailState> = _state

    init {
        savedStateHandle.get<String>("recipeId")?.let { recipeIdString ->
            val recipeId = recipeIdString.toInt()
            getRecipeWithIngredients(recipeId)
        }
    }

    private fun getRecipeWithIngredients(recipeId: Int) = viewModelScope.launch {
        val recipeIngredients = repository.getRecipeWithIngredients(recipeId = recipeId)
        val updatedState = state.value.copy(
            recipe = recipeIngredients.recipe.toRecipe(),
            ingredients = recipeIngredients.ingredients.map { it.toIngredient() }
        )
        _state.value = updatedState
    }

    private fun updateRecipeTitle(newRecipeTitle: String) = viewModelScope.launch {
        val newState = _state.value.recipe.copy(recipeTitle = newRecipeTitle)
        repository.updateRecipe(newState)
        _state.value = _state.value.copy(recipe = newState)
    }

    private fun updateIngredient(ingredient: Ingredient) = viewModelScope.launch {
        repository.updateIngredient(ingredient)
    }

    private fun updateRecipeCategory(newCategory: FoodCategory) = viewModelScope.launch {
        val newState = _state.value.recipe.copy(foodCategory = newCategory)
        repository.updateRecipe(newState)
        _state.value = _state.value.copy(recipe = newState)
    }

    fun onEvent(event: RecipeDetailEvent) {
        when(event) {

            is RecipeDetailEvent.UpdateRecipeTitleEvent -> {
                updateRecipeTitle(newRecipeTitle = event.newRecipeTitle)
            }

            is RecipeDetailEvent.UpdateIngredientEvent -> {
                updateIngredient(ingredient = event.ingredient)
            }

            is RecipeDetailEvent.UpdateFoodCategoryEvent -> {
                updateRecipeCategory(newCategory = event.foodCategory)
            }
        }
    }

}