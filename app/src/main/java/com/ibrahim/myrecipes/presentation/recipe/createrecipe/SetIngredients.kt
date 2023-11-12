package com.ibrahim.myrecipes.presentation.recipe.createrecipe

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.data.converter.DecimalFormatter
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import com.ibrahim.myrecipes.data.enums.getAllIngredientQuantityUnits
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.presentation.recipe.CreateRecipeEvent
import com.ibrahim.myrecipes.presentation.recipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import java.math.BigDecimal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetIngredients(
    navController: NavController,
    viewModel: RecipeViewModel = hiltViewModel()
) {

    val quantityUnits = getAllIngredientQuantityUnits()
    val ingredientDropdownExpanded = remember { mutableStateMapOf<Int, Boolean>() }

    var ingredients by remember {
        mutableStateOf(
            listOf(
                Ingredient(
                    0L,
                    null,
                    "",
                    BigDecimal.ZERO,
                    IngredientQuantityUnit.GRAM
                )
            )
        )
    }

    ingredientDropdownExpanded[0] = false

    Surface(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(8.dp),
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
                            onClick = {
                                viewModel.onEvent(
                                    CreateRecipeEvent
                                        .SetIngredients(ingredients)
                                )
                                navController.navigate(Screen.RecipeInstructions.route)
                                      },
                            modifier = Modifier.weight(1f),
                            enabled = ingredients[0].ingredientName.isNotBlank() &&
                                    ingredients[0].ingredientQuantity!! > BigDecimal.ZERO
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
                                0,
                                null,
                                "",
                                BigDecimal.ZERO,
                                IngredientQuantityUnit.GRAM
                            )
                            ingredientDropdownExpanded[ingredients.size - 1] = false
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
                                    expanded = ingredientDropdownExpanded[index]!!,
                                    onExpandedChange = {
                                        ingredientDropdownExpanded[index] =
                                            !ingredientDropdownExpanded.get(index)!!
                                    }
                                )
                                {
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .menuAnchor(),
                                        readOnly = true,
                                        value = ingredients[index].ingredientQuantityUnit.value,
                                        onValueChange = { },
                                        singleLine = true,
                                        colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                                    )
                                    ExposedDropdownMenu(
                                        expanded = ingredientDropdownExpanded[index]!!,
                                        onDismissRequest = {
                                            ingredientDropdownExpanded[index] = false
                                        }
                                    ) {
                                        quantityUnits.forEach { selectionOption ->
                                            DropdownMenuItem(
                                                text = { Text(text = selectionOption.value) },
                                                onClick = {
                                                    ingredients = ingredients.toMutableList().also {
                                                        it[index] =
                                                            it[index].copy(ingredientQuantityUnit = selectionOption)
                                                    }
                                                    ingredientDropdownExpanded[index] = false
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