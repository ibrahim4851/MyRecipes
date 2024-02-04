package com.ibrahim.myrecipes.presentation.home.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.enums.getAllFoodCategories
import com.ibrahim.myrecipes.data.enums.getLabel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyChipGroup(onChipSelected: (selectedCategories: List<FoodCategory>) -> Unit) {
    val categoryList: List<FoodCategory> = getAllFoodCategories()
    val selectedChipState = remember { mutableStateMapOf<FoodCategory, Boolean>() }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        items(categoryList) { category ->
            FilterChip(
                selected = selectedChipState[category] ?: false,
                onClick = {
                    // Toggle the selected state for this category
                    selectedChipState[category] = !(selectedChipState[category] ?: false)
                    // Immediately update the list of selected categories
                    val selectedCategories = selectedChipState.filter { it.value }.keys.toList()
                    onChipSelected(selectedCategories)
                },
                label = { Text(text = category.getLabel()) },
                leadingIcon = {
                    if (selectedChipState[category] == true) {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = null,
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                },
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}
