package com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog

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
import androidx.compose.ui.res.stringResource
import com.ibrahim.myrecipes.R

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
                label = { Text(text = stringResource(id = R.string.new_instruction)) })
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
                Text(text = stringResource(id = R.string.confirm), color = MaterialTheme.colorScheme.onBackground)
            }
        },
        dismissButton = {
            Row {
                TextButton(
                    onClick = {
                        onDismissRequest()
                    }
                ) {
                    Text(text = stringResource(id = R.string.dismiss), color = MaterialTheme.colorScheme.onBackground)
                }
                TextButton(
                    onClick = onDelete
                ) {
                    Text(text = stringResource(id = R.string.delete), color = MaterialTheme.colorScheme.error)
                }
            }
        }
    )
}