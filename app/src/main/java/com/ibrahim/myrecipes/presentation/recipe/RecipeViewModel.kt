package com.ibrahim.myrecipes.presentation.recipe

import androidx.lifecycle.ViewModel
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val repository: RecipeRepository): ViewModel() {



}