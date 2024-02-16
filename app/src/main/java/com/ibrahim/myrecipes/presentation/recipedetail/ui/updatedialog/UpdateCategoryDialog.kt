package com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.presentation.createrecipe.ui.CategorySelector

@Composable
fun UpdateCategoryDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (FoodCategory) -> Unit,
    dialogTitle: String,
    initialCategory: FoodCategory,
    icon: ImageVector
) {

    val selectedChipState = remember { mutableStateMapOf<FoodCategory, Boolean>() }
    val isChipSelected = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = initialCategory) {
        selectedChipState.clear()
        selectedChipState[initialCategory] = true
        isChipSelected.value = true
    }

    AlertDialog(
        icon = { Icon(icon, contentDescription = null) },
        title = { Text(text = dialogTitle) },
        text = {
            CategorySelector(selectedChipState = selectedChipState, isChipSelected = isChipSelected)
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            val isDifferentFromInitial = selectedChipState.entries.any { it.value && it.key != initialCategory }
            TextButton(
                onClick = {
                    val selectedCategory = selectedChipState.filter { it.value }.keys.firstOrNull()
                    selectedCategory?.let { onConfirmation(it) }
                },
                enabled = isDifferentFromInitial
            ) {
                Text(text = stringResource(id = R.string.confirm), color = MaterialTheme.colorScheme.onBackground)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = stringResource(id = R.string.dismiss), color = MaterialTheme.colorScheme.onBackground)
            }
        }
    )
}

