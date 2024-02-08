package com.ibrahim.myrecipes.presentation.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.myrecipes.data.room.mapper.toIngredientEntity
import com.ibrahim.myrecipes.data.room.mapper.toRecipeEntity
import com.ibrahim.myrecipes.domain.initial.englishRecipes
import com.ibrahim.myrecipes.domain.initial.englishRecipesIngredients
import com.ibrahim.myrecipes.domain.initial.turkishRecipes
import com.ibrahim.myrecipes.domain.initial.turkishRecipesIngredients
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val repository: RecipeRepository
): ViewModel() {

    fun prepopulateData(isTurkish: Boolean) {
        val recipesToInsert = if (isTurkish) turkishRecipes else englishRecipes
        val ingredientsToInsert = if (isTurkish) turkishRecipesIngredients else englishRecipesIngredients
        viewModelScope.launch {
            repository.insertAllRecipes(recipesToInsert.map { it.toRecipeEntity() })
            repository.insertAllIngredients(ingredientsToInsert.map { it.toIngredientEntity() })

        }
    }

}