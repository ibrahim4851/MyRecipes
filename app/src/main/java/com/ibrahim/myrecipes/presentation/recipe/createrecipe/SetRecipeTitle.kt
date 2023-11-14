package com.ibrahim.myrecipes.presentation.recipe.createrecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.recipe.CreateRecipeEvent
import com.ibrahim.myrecipes.presentation.recipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeTitle(
    navController: NavController,
    viewModel: RecipeViewModel = hiltViewModel()
) {

    var recipeTitle by rememberSaveable { mutableStateOf("") }
    var recipeServings by rememberSaveable { mutableStateOf("") }
    var showTimeDialog by rememberSaveable { mutableStateOf(false) }
    val timePickerState = rememberTimePickerState(
        initialHour = 0,
        initialMinute = 0,
        is24Hour = true
    )
    var selectedHour by remember { mutableIntStateOf(0) }
    var selectedMinute by remember { mutableIntStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize()
    )
    {
        if (showTimeDialog) {
            AlertDialog(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(size = 12.dp)
                    ),
                onDismissRequest = { showTimeDialog = false }
            ) {
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.LightGray.copy(alpha = 0.3f)
                        )
                        .padding(top = 28.dp, start = 20.dp, end = 20.dp, bottom = 12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    TimePicker(state = timePickerState)

                    Row(
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {

                        TextButton(onClick = { showTimeDialog = false }) {
                            Text(text = "Dismiss")
                        }

                        TextButton(
                            onClick = {
                                showTimeDialog = false
                                selectedHour = timePickerState.hour
                                selectedMinute = timePickerState.minute
                            }
                        ) {
                            Text(text = "Confirm")
                        }
                    }
                }
            }
        }

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
                                        selectedMinute + selectedHour * 60,
                                        recipeServings.toInt()
                                    )
                            )
                            navController.navigate(Screen.RecipeCategory.route)
                        },
                        modifier = Modifier.weight(1f),
                        enabled = recipeTitle.isNotEmpty()
                                && recipeServings.isNotEmpty()
                                && selectedMinute + selectedHour > 0
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
                        text = "How long does it take to create this masterpiece?",
                        style = Typography.titleLarge
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Row(
                        modifier = Modifier
                            .width(280.dp)
                            .height(IntrinsicSize.Max)
                    )
                    {
                        Text(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = MaterialTheme.colorScheme.secondary,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(5.dp),
                            text = selectedHour.toString(),
                            style = Typography.headlineLarge
                        )

                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            modifier = Modifier
                                .height(40.dp)
                                .align(Alignment.Bottom),
                            text = "hours"
                        )

                        Spacer(modifier = Modifier.padding(8.dp))

                        Text(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = MaterialTheme.colorScheme.secondary,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(5.dp),
                            text = selectedMinute.toString(),
                            style = Typography.headlineLarge
                        )

                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            modifier = Modifier
                                .height(40.dp)
                                .align(Alignment.Bottom),
                            text = "minutes"
                        )
                    }

                    Button(
                        modifier = Modifier
                            .width(280.dp)
                            .padding(top = 8.dp),
                        onClick = {
                            showTimeDialog = !showTimeDialog
                        }
                    ) {
                        Text(text = "Set the Time")
                    }
                }
            }
        }
    }
}