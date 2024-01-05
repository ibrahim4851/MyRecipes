package com.ibrahim.myrecipes.presentation.createrecipe.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.enums.getAllFoodCategories
import com.ibrahim.myrecipes.presentation.createrecipe.CreateRecipeEvent
import com.ibrahim.myrecipes.presentation.createrecipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SetCategory(
    navController: NavController,
    viewModel: RecipeViewModel = hiltViewModel()
) {

    val selectedChipState = remember { mutableStateMapOf<FoodCategory, Boolean>() }
    val isChipSelected = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize()
    )
    {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    OutlinedButton(
                        modifier = Modifier.weight(1f),
                        onClick = { }
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = {
                            val selectedFoodCategory = selectedChipState.entries.find { it.value }?.key
                            viewModel.onEvent(CreateRecipeEvent.SetCategory(selectedFoodCategory!!))
                            navController.navigate(Screen.RecipeIngredients.route)
                                  },
                        modifier = Modifier.weight(1f),
                        enabled = isChipSelected.value
                    ) {
                        Text(text = "Next")
                    }
                }
            }
            ) { values ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 16.dp, bottom = 16.dp)
            )
            {

                Row(modifier = Modifier.fillMaxWidth()) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(values)
                        .padding(start = 16.dp, end = 8.dp)
                        .weight(1f)
                )
                {
                    Text(
                        text = "What's Your Recipe's Category?",
                        fontWeight = FontWeight.Bold,
                        style = Typography.displaySmall
                    )
                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = "What kind of deliciousness do you bring to the table?",
                        style = Typography.titleLarge
                    )
                    Spacer(modifier = Modifier.padding(8.dp))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val foodCategories = getAllFoodCategories()
                        if (selectedChipState.isEmpty()) {
                            for (foodCategory in foodCategories) {
                                selectedChipState[foodCategory] = false
                            }
                        }
                        foodCategories.forEach { foodCategory ->
                            FilterChip(
                                selected = selectedChipState[foodCategory] == true,
                                onClick = {
                                    if (selectedChipState[foodCategory] == false && !isChipSelected.value) {
                                        selectedChipState[foodCategory] = true
                                        isChipSelected.value = true
                                    }
                                    else if (isChipSelected.value) {
                                        val selectedChip = selectedChipState.filter { (key, value) -> value }
                                        if(selectedChip.entries.first().key == foodCategory){
                                            isChipSelected.value = false
                                            selectedChipState[foodCategory] = false
                                        }else{
                                            selectedChipState[selectedChip.entries.first().key] = false
                                            selectedChipState[foodCategory] = true
                                        }
                                    }
                                },
                                label = { Text(text = foodCategory.name) },
                                leadingIcon = {
                                    Box(modifier = Modifier.animateContentSize(keyframes {
                                        durationMillis = 100
                                    })) {
                                        if (selectedChipState[foodCategory] == true) {
                                            Icon(
                                                imageVector = Icons.Filled.Done,
                                                contentDescription = null,
                                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                                            )
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}