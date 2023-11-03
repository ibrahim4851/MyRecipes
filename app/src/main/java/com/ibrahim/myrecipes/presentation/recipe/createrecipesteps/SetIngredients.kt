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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import com.ibrahim.myrecipes.data.enums.getAllIngredientQuantityUnits
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetIngredients(navController: NavController) {

    var ingredients by remember {
        mutableStateOf(
            mutableListOf(
                Ingredient(
                    null,
                    null,
                    "",
                    null,
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

        Scaffold(modifier = Modifier.fillMaxSize()) { values ->

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
                            ingredients.add(
                                Ingredient(
                                    null,
                                    null,
                                    "",
                                    null,
                                    IngredientQuantityUnit.GRAM
                                )
                            )
                        },
                        enabled = ingredients.last().ingredientName.isNotEmpty()
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
                        items(ingredients) { ingredient ->
                            var ingredientNameTextField by remember { mutableStateOf("") }
                            Row {
                                OutlinedTextField(
                                    value = ingredientNameTextField,
                                    onValueChange = { ingredientNameTextField = it },
                                    placeholder = {
                                        Text(text = "e.g. Hamburger")
                                    }
                                )

                                ExposedDropdownMenuBox(
                                    expanded = ingredientDropdownExpanded,
                                    onExpandedChange = {
                                        ingredientDropdownExpanded = !ingredientDropdownExpanded
                                    })
                                {
                                    TextField(
                                        modifier = Modifier.menuAnchor(),
                                        readOnly = true,
                                        value = selectedQuantity.value,
                                        onValueChange = {},
                                        trailingIcon = { TrailingIcon(
                                            expanded = ingredientDropdownExpanded
                                        ) },
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
                                                    ingredient.ingredientQuantityUnit = selectionOption
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