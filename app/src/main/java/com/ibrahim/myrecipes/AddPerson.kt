package com.ibrahim.myrecipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


data class Person(val name: String, val age: Int)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonListScreen() {
    var persons by remember { mutableStateOf(listOf<Person>()) }
    val nameState = remember { mutableStateOf(TextFieldValue()) }
    val ageState = remember { mutableStateOf(TextFieldValue()) }
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column {
            TextField(
                value = nameState.value,
                onValueChange = { nameState.value = it },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { focusRequester.requestFocus() }),
                placeholder = { Text("Name") }
            )

            TextField(
                value = ageState.value,
                onValueChange = { ageState.value = it },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { /* Handle age input if needed */ }),
                placeholder = { Text("Age") },
                modifier = Modifier.focusRequester(focusRequester)
            )

            Button(
                onClick = {
                    val name = nameState.value.text
                    val age = ageState.value.text.toIntOrNull() ?: 0
                    if (name.isNotEmpty() && age > 0) {
                        val newPerson = Person(name, age)
                        persons = persons + newPerson
                        nameState.value = TextFieldValue()
                        ageState.value = TextFieldValue()
                    }
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Add Person")
            }
        }

        LazyColumn {
            items(persons) { person ->
                Text(text = "Name: ${person.name}, Age: ${person.age}")
            }
        }
    }
}

