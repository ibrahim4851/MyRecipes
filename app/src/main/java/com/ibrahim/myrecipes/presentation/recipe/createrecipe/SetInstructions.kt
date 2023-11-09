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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetInstructions(navController: NavController) {

    val instructions = remember { mutableStateListOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Column {
                Row(
                    modifier = Modifier
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
                        onClick = { navController.navigate(Screen.RecipeImage.route) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Next")
                    }
                }
            }

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
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
                    .padding(paddingValues)
                    .padding(start = 16.dp, end = 8.dp)
                    .weight(1f)
            ) {

                Text(
                    text = "Here's Your Instructions",
                    fontWeight = FontWeight.Bold,
                    style = Typography.displaySmall
                )
                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Define the Steps of Creating This Masterpiece",
                    style = Typography.titleLarge
                )
                Spacer(modifier = Modifier.padding(8.dp))

                IconButton(
                    onClick = {
                        instructions.add("")
                    },
                    enabled = instructions.last().isNotBlank()
                ) {
                    Icon(Icons.Outlined.Add, contentDescription = "")
                }

                LazyColumn(
                    modifier = Modifier
                        .animateContentSize(keyframes {
                            durationMillis = 100
                        })
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(instructions.size) { index ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                modifier = Modifier
                                    .weight(1f)
                                    .align(Alignment.CenterVertically),
                                text = (index + 1).toString() + ".",
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.Bold
                            )
                            OutlinedTextField(
                                modifier = Modifier.weight(9f),
                                value = instructions[index],
                                onValueChange = { newValue ->
                                    instructions[index] = newValue
                                }
                            )
                        }
                    }
                }

            }
        }
    }

}