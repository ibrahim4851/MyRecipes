package com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialogs

import androidx.compose.foundation.layout.Row
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
fun UpdateInstructionDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (String) -> Unit,
    dialogTitle: String,
    instruction: String,
    onDelete: () -> Unit,
    icon: ImageVector
) {
    var newInstruction by remember { mutableStateOf(instruction) }

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            OutlinedTextField(
                value = newInstruction,
                onValueChange = { newInstruction = it },
                label = { Text(text = "New Title") })
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation(newInstruction)
                },
                enabled = (newInstruction != instruction)
            ) {
                Text("Confirm", color = MaterialTheme.colorScheme.onBackground)
            }
        },
        dismissButton = {
            Row {
                TextButton(
                    onClick = {
                        onDismissRequest()
                    }
                ) {
                    Text("Dismiss", color = MaterialTheme.colorScheme.onBackground)
                }
                TextButton(
                    onClick = onDelete
                ) {
                    Text("Delete", color = MaterialTheme.colorScheme.error)
                }
            }
        }
    )
}