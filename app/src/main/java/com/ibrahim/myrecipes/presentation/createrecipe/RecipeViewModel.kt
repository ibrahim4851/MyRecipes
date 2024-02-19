package com.ibrahim.myrecipes.presentation.createrecipe

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.repository.Ingredients
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    private val _state = mutableStateOf(CreateRecipeState())
    val state: State<CreateRecipeState> = _state

    private fun setTitleMinuteServings(title: String, minute: Int, servings: Int) {
        val currentState = _state.value
        val updatedRecipe = currentState.recipe.copy(
            recipeTitle = title,
            recipeTime = minute,
            recipeServings = servings
        )
        _state.value = currentState.copy(recipe = updatedRecipe)
    }

    private fun setCategory(category: FoodCategory) {
        val currentState = _state.value
        val updatedRecipe = currentState.recipe.copy(foodCategory = category)
        _state.value = currentState.copy(recipe = updatedRecipe)
    }

    private fun setIngredients(ingredients: Ingredients) {
        val capitalizedIngredients = ingredients.map { ingredient ->
            ingredient.copy(ingredientName = ingredient.ingredientName.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            })
        }
        val currentState = _state.value
        val updatedState = currentState.copy(ingredients = capitalizedIngredients)
        _state.value = updatedState
    }


    private fun setInstructions(instructions: List<String>) {
        val capitalizedInstructions = instructions.map { instruction ->
            instruction.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }

        val currentState = _state.value
        val updatedRecipe =
            currentState.recipe.copy(recipeInstructions = capitalizedInstructions)
        _state.value = currentState.copy(recipe = updatedRecipe)
    }


    private fun setImage(uri: Uri) {
        val currentState = _state.value
        val updatedRecipe = currentState.recipe.copy(recipePhotoUri = uri.toString())
        _state.value = currentState.copy(recipe = updatedRecipe)
    }

    private suspend fun saveRecipe() {
        val recipeId = repository.insertRecipe(_state.value.recipe)
        val updatedIngredients = _state.value.ingredients.map { ingredient ->
            ingredient.copy(ownerRecipeId = recipeId)
        }
        repository.insertIngredients(updatedIngredients)
    }

    fun onEvent(event: CreateRecipeEvent) {
        when (event) {
            is CreateRecipeEvent.SetTitleMinuteServings -> {
                setTitleMinuteServings(event.title, event.minute, event.servings)
            }

            is CreateRecipeEvent.SetCategory -> {
                setCategory(event.category)
            }

            is CreateRecipeEvent.SetIngredients -> {
                setIngredients(event.ingredients)
            }

            is CreateRecipeEvent.SetInstructions -> {
                setInstructions(event.instructions)
            }

            is CreateRecipeEvent.SetImage -> {
                setImage(event.uri)
            }

            is CreateRecipeEvent.SaveRecipe -> {
                viewModelScope.launch {
                    saveRecipe()
                }
            }
        }
    }

}