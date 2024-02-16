package com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.enums.getAllIngredientQuantityUnits
import com.ibrahim.myrecipes.data.enums.getLabel
import com.ibrahim.myrecipes.domain.model.Ingredient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateIngredientDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (Ingredient) -> Unit,
    dialogTitle: String,
    onDelete: () -> Unit,
    initialIngredient: Ingredient,
    icon: ImageVector
) {

    var ingredientName by remember { mutableStateOf(initialIngredient.ingredientName) }
    var ingredientQuantity by remember { mutableStateOf(initialIngredient.ingredientQuantity.toString()) }
    var ingredientDropdownExpanded by remember { mutableStateOf(false) }
    var ingredientQuantityUnit by remember { mutableStateOf(initialIngredient.ingredientQuantityUnit) }
    val quantityUnits = getAllIngredientQuantityUnits()

    AlertDialog(
        icon = { Icon(icon, contentDescription = null) },
        title = { Text(text = dialogTitle) },
        text = {
            Row {
                OutlinedTextField(
                    modifier = Modifier.weight(6f),
                    value = ingredientName,
                    onValueChange = { newValue ->
                        ingredientName = newValue
                    },
                    placeholder = {
                        Text(text = stringResource(R.string.e_g_flour))
                    }
                )
                Spacer(Modifier.size(4.dp))
                OutlinedTextField(
                    modifier = Modifier.weight(3f),
                    value = ingredientQuantity,
                    onValueChange = {
                        if (it.isEmpty() || it.toDoubleOrNull() != null) {
                            ingredientQuantity = it
                        }
                    },
                    singleLine = true,
                    placeholder = {
                        Text(text = stringResource(R.string.e_g_2))
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
                Spacer(Modifier.size(4.dp))
                ExposedDropdownMenuBox(
                    modifier = Modifier.weight(4f),
                    expanded = ingredientDropdownExpanded,
                    onExpandedChange = {
                        ingredientDropdownExpanded = !ingredientDropdownExpanded
                    }
                )
                {
                    OutlinedTextField(
                        modifier = Modifier
                            .menuAnchor(),
                        readOnly = true,
                        value = ingredientQuantityUnit.getLabel(),
                        onValueChange = { },
                        singleLine = true,
                        colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                    )
                    ExposedDropdownMenu(
                        expanded = ingredientDropdownExpanded,
                        onDismissRequest = {
                            ingredientDropdownExpanded = false
                        }
                    ) {
                        quantityUnits.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(text = selectionOption.getLabel()) },
                                onClick = {
                                    ingredientQuantityUnit = selectionOption
                                    ingredientDropdownExpanded = false
                                }
                            )
                        }
                    }
                }

            }

        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation(
                        initialIngredient
                            .copy(
                                ingredientName = ingredientName,
                                ingredientQuantity = ingredientQuantity.toBigDecimal(),
                                ingredientQuantityUnit = ingredientQuantityUnit
                            )
                    )
                },
                enabled = initialIngredient.ingredientName != ingredientName
                        || initialIngredient.ingredientQuantityUnit != ingredientQuantityUnit
                        || (ingredientQuantity.isNotEmpty() && initialIngredient.ingredientQuantity != ingredientQuantity.toBigDecimal())
            ) {
                Text(text = stringResource(id = R.string.confirm), color = MaterialTheme.colorScheme.onBackground)
            }
        },
        dismissButton = {
            Row {
                TextButton(onClick = onDismissRequest) {
                    Text(text = stringResource(id = R.string.dismiss), color = MaterialTheme.colorScheme.onBackground)
                }
                TextButton(onClick = onDelete) {
                    Text(text = stringResource(id = R.string.delete), color = MaterialTheme.colorScheme.error)
                }
            }
        }
    )

}