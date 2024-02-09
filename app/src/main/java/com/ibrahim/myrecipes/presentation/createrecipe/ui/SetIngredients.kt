package com.ibrahim.myrecipes.presentation.createrecipe.ui

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import com.ibrahim.myrecipes.data.enums.getAllIngredientQuantityUnits
import com.ibrahim.myrecipes.data.enums.getLabel
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.presentation.createrecipe.CreateRecipeEvent
import com.ibrahim.myrecipes.presentation.createrecipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import com.ibrahim.myrecipes.util.SwipeToDeleteContainer
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

    var ingredientQuantities by remember {
        mutableStateOf(
            listOf("")
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
                            Text(text = stringResource(id = R.string.cancel))
                        }
                        Button(
                            onClick = {
                                ingredients = ingredients.mapIndexed { index, ingredient ->
                                    val quantityStr = ingredientQuantities[index]
                                    val quantity =
                                        quantityStr.toBigDecimalOrNull() ?: BigDecimal.ZERO
                                    ingredient.copy(ingredientQuantity = quantity)
                                }
                                viewModel.onEvent(CreateRecipeEvent.SetIngredients(ingredients))
                                navController.navigate(Screen.RecipeInstructions.route)
                            },
                            modifier = Modifier.weight(1f),
                            enabled = ingredients.all { it.ingredientName.isNotBlank() } && ingredientQuantities.all { it.isNotEmpty() }
                        ) {
                            Text(text = stringResource(id = R.string.next))
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
                        text = stringResource(R.string.add_your_ingredients),
                        fontWeight = FontWeight.Bold,
                        style = Typography.displaySmall
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = stringResource(R.string.what_are_the_key_players),
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
                            ingredientQuantities = ingredientQuantities + ""
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
                            SwipeToDeleteContainer(
                                item = ingredients[index],
                                onDelete = {
                                    if (index > 0) {
                                        ingredients -= ingredients[index]
                                    }
                                }) {
                                Row {
                                    var text by remember { mutableStateOf(ingredientQuantities[index]) }
                                    OutlinedTextField(
                                        modifier = Modifier.weight(6f),
                                        value = ingredients[index].ingredientName,
                                        onValueChange = { newValue ->
                                            ingredients = ingredients.toMutableList().also {
                                                it[index] =
                                                    it[index].copy(ingredientName = newValue)
                                            }
                                        },
                                        placeholder = {
                                            Text(text = stringResource(R.string.e_g_flour))
                                        }
                                    )

                                    Spacer(modifier = Modifier.weight(0.5f))

                                    OutlinedTextField(
                                        modifier = Modifier.weight(3f),
                                        value = text,
                                        onValueChange = {
                                            if (it.isEmpty() || it.toDoubleOrNull() != null) {
                                                text = it
                                                ingredientQuantities =
                                                    ingredientQuantities.toMutableList().apply {
                                                        set(index, it)
                                                    }
                                            }
                                        },
                                        singleLine = true,
                                        placeholder = {
                                            Text(text = stringResource(R.string.e_g_2))
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
                                            value = ingredients[index].ingredientQuantityUnit.getLabel(),
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
                                                    text = { Text(text = selectionOption.getLabel()) },
                                                    onClick = {
                                                        ingredients =
                                                            ingredients.toMutableList().also {
                                                                it[index] =
                                                                    it[index].copy(
                                                                        ingredientQuantityUnit = selectionOption
                                                                    )
                                                            }
                                                        ingredientDropdownExpanded[index] = false
                                                    }
                                                )
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
}

fun DecimalInputVisualTransformation(): VisualTransformation {
    return VisualTransformation { text ->
        val transformed = AnnotatedString.Builder()
        var decimalAdded = false
        text.forEach { char ->
            if (!decimalAdded && char.isDigit()) {
                transformed.pushStyle(SpanStyle(color = Color.Transparent))
                transformed.append(".")
                transformed.pop()
                decimalAdded = true
            }
            transformed.append(char)
        }
        TransformedText(transformed.toAnnotatedString(), OffsetMapping.Identity)
    }
}

