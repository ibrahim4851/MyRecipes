package com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateServingAndTimeDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (updatedServings: Int, updatedTimeInMinutes: Int) -> Unit,
    dialogTitle: String,
    recipeTime: Int,
    recipeServings: Int,
    icon: ImageVector
) {
    val (initialHour, initialMinute) = remember { minutesToHoursAndMinutes(recipeTime) }
    val timePickerState = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = true
    )

    var newRecipeServing by remember { mutableStateOf(recipeServings.toString()) }

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Column {
                TimePicker(state = timePickerState)
                OutlinedTextField(
                    value = newRecipeServing,
                    onValueChange = { newRecipeServing = it },
                    label = { Text(text = "New Servings") }
                )
            }
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val updatedTimeInMinutes = timePickerState.hour * 60 + timePickerState.minute
                    val updatedServings = newRecipeServing.toIntOrNull() ?: recipeServings
                    onConfirmation(updatedServings, updatedTimeInMinutes)
                }
            ) {
                Text("Confirm", color = MaterialTheme.colorScheme.onBackground)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss", color = MaterialTheme.colorScheme.onBackground)
            }
        }
    )
}


fun minutesToHoursAndMinutes(totalMinutes: Int): Pair<Int, Int> {
    val hours = totalMinutes / 60
    val minutes = totalMinutes % 60
    return Pair(hours, minutes)
}