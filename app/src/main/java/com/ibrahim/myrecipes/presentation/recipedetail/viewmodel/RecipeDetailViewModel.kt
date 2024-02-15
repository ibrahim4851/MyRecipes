package com.ibrahim.myrecipes.presentation.recipedetail.viewmodel

import android.util.Log
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
        getRecipeWithIngredients(_state.value.recipe.recipeId.toInt())
    }

    private fun updateRecipeCategory(newCategory: FoodCategory) = viewModelScope.launch {
        val newState = _state.value.recipe.copy(foodCategory = newCategory)
        repository.updateRecipe(newState)
        _state.value = _state.value.copy(recipe = newState)
    }

    private fun deleteIngredient(ingredientId: Long) = viewModelScope.launch {
        repository.deleteIngredient(ingredientId)
        getRecipeWithIngredients(_state.value.recipe.recipeId.toInt())
    }

    private fun deleteInstruction(position: Int) = viewModelScope.launch {
        if (position in _state.value.recipe.recipeInstructions.indices) {
            val updatedInstructions = _state.value.recipe.recipeInstructions.toMutableList().apply {
                removeAt(position)
            }
            val updatedRecipe = _state.value.recipe.copy(recipeInstructions = updatedInstructions)
            repository.updateRecipe(updatedRecipe)
            getRecipeWithIngredients(_state.value.recipe.recipeId.toInt())
        } else {
            Log.e("DeleteInstruction", "Invalid position: $position for instruction list")
        }
    }

    private fun addInstruction(newInstruction: String) = viewModelScope.launch {
        if (newInstruction.isNotBlank()) {
            val updatedInstructions = _state.value.recipe.recipeInstructions.toMutableList().apply {
                add(newInstruction)
            }
            val updatedRecipe = _state.value.recipe.copy(recipeInstructions = updatedInstructions)
            repository.updateRecipe(updatedRecipe)
            getRecipeWithIngredients(_state.value.recipe.recipeId.toInt())
        } else {
            Log.e("AddInstruction", "Attempted to add an empty instruction")
        }
    }


    private fun updateInstruction(newInstruction: String, position: Int) = viewModelScope.launch {
        val currentInstructions = _state.value.recipe.recipeInstructions.toMutableList()

        if (position in currentInstructions.indices) {
            currentInstructions[position] = newInstruction
            val updatedRecipe = _state.value.recipe.copy(recipeInstructions = currentInstructions)
            repository.updateRecipe(updatedRecipe)
            getRecipeWithIngredients(_state.value.recipe.recipeId.toInt())
        } else {
            Log.e("UpdateInstruction", "Invalid position: $position for instruction list")
        }
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

            is RecipeDetailEvent.DeleteIngredientEvent -> {
                deleteIngredient(event.ingredientId)
            }

            is RecipeDetailEvent.DeleteInstructionEvent -> {
                deleteInstruction(event.position)
            }

            is RecipeDetailEvent.UpdateInstructionEvent -> {
                updateInstruction(event.newInstruction, event.position)
            }

            is RecipeDetailEvent.AddInstructionEvent -> {
                addInstruction(event.newInstruction)
            }
        }
    }
}