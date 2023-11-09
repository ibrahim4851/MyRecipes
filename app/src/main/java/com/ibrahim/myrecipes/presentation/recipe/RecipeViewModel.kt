package com.ibrahim.myrecipes.presentation.recipe

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository) : ViewModel() {

    private val _state = mutableStateOf(CreateRecipeState())
    val state: State<CreateRecipeState> = _state

    private fun setTitleMinuteServings() {}

    private fun setCategory() {}

    private fun setIngredients() {}

    private fun setInstructions() {}

    private fun setImage() {}

    fun onEvent(event: CreateRecipeEvent) {
        when (event) {
            is CreateRecipeEvent.SetTitleMinuteServings -> {

            }

            is CreateRecipeEvent.SetCategory -> {

            }

            is CreateRecipeEvent.SetIngredients -> {

            }

            is CreateRecipeEvent.SetInstructions -> {

            }

            is CreateRecipeEvent.SetImage -> {

            }
        }
    }

}