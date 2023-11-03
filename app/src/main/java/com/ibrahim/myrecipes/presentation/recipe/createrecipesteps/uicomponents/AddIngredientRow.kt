package com.ibrahim.myrecipes.presentation.recipe.createrecipesteps.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibrahim.myrecipes.data.enums.getAllIngredientQuantityUnits
import com.ibrahim.myrecipes.domain.model.Ingredient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddIngredientRow (
    onIngredientName: () -> Unit,
    onUnitSelect: () -> Unit,
    onQuantity: () -> Unit,
    ingredient: Ingredient
) {
    Row(modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

        var ingredientName by remember { mutableStateOf(ingredient.ingredientName) }
        var ingredientQuantity by remember { mutableStateOf(ingredient.ingredientQuantity?.toString() ?: "") }
        var ingredientQuantityUnit by remember { mutableStateOf(ingredient.ingredientQuantityUnit) }
        val quantityUnits = getAllIngredientQuantityUnits()
        var ingredientDropdownExpanded by remember { mutableStateOf(false) }
        var selectedQuantity by remember {
            mutableStateOf(quantityUnits[0])
        }

        OutlinedTextField(
            value = ingredientName,
            onValueChange = { onIngredientName },
            placeholder = {
                Text(text = "e.g. Hamburger")
            }
        )



    }
}