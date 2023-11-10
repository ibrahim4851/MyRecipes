package com.ibrahim.myrecipes.presentation.recipe.createrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.recipe.CreateRecipeEvent
import com.ibrahim.myrecipes.presentation.recipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.duration.DurationDialog
import com.maxkeppeler.sheets.duration.models.DurationConfig
import com.maxkeppeler.sheets.duration.models.DurationFormat
import com.maxkeppeler.sheets.duration.models.DurationSelection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeTitle(
    navController: NavController,
    viewModel: RecipeViewModel = hiltViewModel()
) {

    var recipeTitle by rememberSaveable { mutableStateOf("") }
    var recipeServings by rememberSaveable { mutableStateOf("") }
    var recipeTime by rememberSaveable { mutableStateOf("") }

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
                        .padding(start = 8.dp, bottom = 8.dp),
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
                                    .SetTitleMinuteServings(
                                        recipeTitle,
                                        recipeTime.toInt(),
                                        recipeServings.toInt()
                                    )
                            )
                            navController.navigate(Screen.RecipeCategory.route)
                        },
                        modifier = Modifier.weight(1f),
                        enabled = recipeTitle.isNotEmpty()
                                && recipeServings.isNotEmpty()
                                && recipeTime.isNotEmpty()
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
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
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
                        text = "Let's Create Your Recipe",
                        fontWeight = FontWeight.Bold,
                        style = Typography.displaySmall
                    )
                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = "Keep the Title Short and Precise",
                        style = Typography.titleLarge
                    )
                    Spacer(modifier = Modifier.padding(8.dp))

                    OutlinedTextField(
                        value = recipeTitle,
                        onValueChange = { recipeTitle = it },
                        singleLine = true,
                        placeholder = {
                            Text(text = "e.g. Hamburger")
                        }
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = "How many servings does your recipe contain?",
                        style = Typography.titleLarge
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    OutlinedTextField(
                        value = recipeServings,
                        onValueChange = { value ->
                            recipeServings = value.filter { it.isDigit() }
                        },
                        singleLine = true,
                        placeholder = {
                            Text(text = "e.g. 2")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = "How many minutes do we need to create this masterpiece?",
                        style = Typography.titleLarge
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    val selectedTimeInSeconds = remember { mutableLongStateOf(240) }
                    DurationDialog(
                        state = rememberUseCaseState(
                            visible = true,
                            onCloseRequest = {  }
                        ),
                        selection = DurationSelection { newTimeInSeconds ->
                            selectedTimeInSeconds.longValue = newTimeInSeconds
                        },
                        config = DurationConfig(
                            timeFormat = DurationFormat.HH_MM,
                            minTime = 30,
                            maxTime = 240
                        )
                    )

                    OutlinedTextField(
                        value = recipeTime,
                        onValueChange = { value ->
                            recipeTime = value.filter { it.isDigit() }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        placeholder = {
                            Text(text = "e.g. 1 hour and 15 minutes")
                        },
                    )

                }
            }
        }
    }
}