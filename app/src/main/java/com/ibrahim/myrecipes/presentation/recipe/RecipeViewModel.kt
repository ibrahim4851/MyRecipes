package com.ibrahim.myrecipes.presentation.recipe

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.repository.Ingredients
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository) : ViewModel() {

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

    }

    private fun setInstructions(instructions: List<String>) {
        val currentState = _state.value
        val updatedRecipe = currentState.recipe.copy(recipeInstructions = instructions.joinToString("\n"))
        _state.value = currentState.copy(recipe = updatedRecipe)
    }

    private fun setImage(uri: Uri) {
        val currentState = _state.value
        val updatedRecipe = currentState.recipe.copy(recipePhotoUri = uri.toString())
        _state.value = currentState.copy(recipe = updatedRecipe)
    }

    private fun saveRecipe() {

    }

    fun onEvent(event: CreateRecipeEvent) {
        when (event) {
            is CreateRecipeEvent.SetTitleMinuteServings -> {
                setTitleMinuteServings(event.title, event.minute, event.servings)
                Log.i("statevaluer", _state.value.recipe.toString())
            }

            is CreateRecipeEvent.SetCategory -> {
                setCategory(event.category)
                Log.i("statevaluer", _state.value.recipe.toString())
            }

            is CreateRecipeEvent.SetIngredients -> {
                setIngredients(event.ingredients)
                Log.i("statevaluer", _state.value.recipe.toString())
            }

            is CreateRecipeEvent.SetInstructions -> {
                setInstructions(event.instructions)
                Log.i("statevaluer", _state.value.recipe.toString())
            }

            is CreateRecipeEvent.SetImage -> {
                setImage(event.uri)
                Log.i("statevaluer", _state.value.recipe.toString())
            }

            is CreateRecipeEvent.SaveRecipe -> {
                saveRecipe()
            }
        }
    }

}