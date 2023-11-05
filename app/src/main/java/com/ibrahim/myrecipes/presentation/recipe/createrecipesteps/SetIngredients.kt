package com.ibrahim.myrecipes.presentation.recipe.createrecipesteps

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.data.converter.DecimalFormatter
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import com.ibrahim.myrecipes.data.enums.getAllIngredientQuantityUnits
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import java.math.BigDecimal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetIngredients(navController: NavController) {

    var ingredients by remember {
        mutableStateOf(
            listOf(
                Ingredient(
                    null,
                    null,
                    "",
                    BigDecimal.ZERO,
                    IngredientQuantityUnit.GRAM
                )
            )
        )
    }

    val quantityUnits = getAllIngredientQuantityUnits()
    var ingredientDropdownExpanded by remember { mutableStateOf(false) }
    var selectedQuantity by remember {
        mutableStateOf(quantityUnits[0])
    }

    Surface(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        OutlinedButton(
                            modifier = Modifier.weight(1f),
                            onClick = { navController.popBackStack() }
                        ) {
                            Text(text = "Cancel")
                        }
                        Button(
                            onClick = { navController.navigate(Screen.RecipeInstructions.route) },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Next")
                        }
                    }
                }

            }
        ) { values ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 16.dp, bottom = 16.dp)
            ) {
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
                ) {
                    Text(
                        text = "Add Your Ingredients",
                        fontWeight = FontWeight.Bold,
                        style = Typography.displaySmall
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = "What Are the Key Players?",
                        style = Typography.titleLarge
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    IconButton(
                        onClick = {
                            ingredients = ingredients + Ingredient(
                                null,
                                null,
                                "",
                                BigDecimal.ZERO,
                                IngredientQuantityUnit.GRAM
                            )
                        },
                        enabled = ingredients.last().ingredientName.isNotBlank()
                    ) {
                        Icon(Icons.Outlined.Add, contentDescription = "")
                    }

                    LazyColumn(
                        modifier = Modifier
                            .animateContentSize(keyframes {
                                durationMillis = 100
                            }),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(ingredients.size) { index ->
                            var ingredientQuantity by remember { mutableStateOf("") }
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.weight(6f),
                                    value = ingredients[index].ingredientName,
                                    onValueChange = { newValue ->
                                        ingredients = ingredients.toMutableList().also {
                                            it[index] = it[index].copy(ingredientName = newValue)
                                        }
                                    },
                                    placeholder = {
                                        Text(text = "e.g. Flour")
                                    }
                                )

                                Spacer(modifier = Modifier.weight(0.5f))

                                OutlinedTextField(
                                    modifier = Modifier.weight(3f),
                                    value = ingredients[index].ingredientQuantity?.toString() ?: "",
                                    onValueChange = { newValue ->
                                        val decimalFormatter = DecimalFormatter()
                                        val formattedValue = decimalFormatter.cleanup(newValue)
                                        ingredients = ingredients.toMutableList().also {
                                            it[index] = if (formattedValue.isBlank()) {
                                                it[index].copy(ingredientQuantity = null)
                                            } else {
                                                val quantity = formattedValue.toBigDecimal()
                                                it[index].copy(ingredientQuantity = quantity)
                                            }
                                        }
                                    },
                                    placeholder = {
                                        Text(text = "e.g. 2")
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                                )

                                Spacer(modifier = Modifier.weight(0.5f))

                                ExposedDropdownMenuBox(
                                    modifier = Modifier.weight(4f),
                                    expanded = ingredientDropdownExpanded,
                                    onExpandedChange = {
                                        ingredientDropdownExpanded = !ingredientDropdownExpanded
                                    }
                                )
                                {
                                    TextField(
                                        modifier = Modifier.menuAnchor(),
                                        readOnly = true,
                                        value = selectedQuantity.value,
                                        onValueChange = { },
                                        trailingIcon = {
                                            TrailingIcon(
                                                expanded = ingredientDropdownExpanded
                                            )
                                        },
                                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                                    )
                                    ExposedDropdownMenu(
                                        expanded = ingredientDropdownExpanded,
                                        onDismissRequest = { ingredientDropdownExpanded = false }
                                    ) {
                                        quantityUnits.forEach { selectionOption ->
                                            DropdownMenuItem(
                                                text = { Text(text = selectionOption.value) },
                                                onClick = {
                                                    selectedQuantity = selectionOption
                                                    ingredients[index].ingredientQuantityUnit =
                                                        selectionOption
                                                    ingredientDropdownExpanded = false
                                                })
                                        }
                                    }
                                }

                            }

                        }
                    }
                }
            }

        }
    }
}