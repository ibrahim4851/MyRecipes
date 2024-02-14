package com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialogs

import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun UpdateTitleDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (String) -> Unit,
    dialogTitle: String,
    recipeTitle: String,
    icon: ImageVector
) {

    var newTitle by remember { mutableStateOf(recipeTitle) }

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            OutlinedTextField(
                value = newTitle,
                onValueChange = { newTitle = it },
                label = { Text(text = "New Title") })
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation(newTitle)
                },
                enabled = (newTitle != recipeTitle)
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