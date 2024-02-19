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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.presentation.createrecipe.CreateRecipeEvent
import com.ibrahim.myrecipes.presentation.createrecipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.navigation.Screen
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import com.ibrahim.myrecipes.util.SwipeToDeleteContainer
import com.ibrahim.myrecipes.util.canGoBack

@Composable
fun SetInstructions(
    navController: NavController,
    viewModel: RecipeViewModel = hiltViewModel()
) {


    var instructionsList by remember {
        mutableStateOf(listOf(Pair(0, "")))
    }
    var nextId by remember { mutableStateOf(1) }


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
                            viewModel.onEvent(
                                CreateRecipeEvent
                                    .SetInstructions(instructionsList.map { it.second })
                            )
                            navController.navigate(Screen.RecipeImage.route)
                        },
                        modifier = Modifier.weight(1f),
                        enabled = instructionsList[0].second.isNotBlank()
                    ) {
                        Text(text = stringResource(id = R.string.next))
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
                IconButton(onClick = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                })
                {
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
                    text = stringResource(R.string.here_s_your_instructions),
                    fontWeight = FontWeight.Bold,
                    style = Typography.displaySmall
                )
                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.define_the_steps_of_creating_this_masterpiece),
                    style = Typography.titleLarge
                )
                Spacer(modifier = Modifier.padding(8.dp))

                IconButton(
                    onClick = {
                        if (instructionsList.last().second.isNotBlank()) {
                            instructionsList += Pair(nextId++, "")
                        }
                    },
                    enabled = instructionsList.last().second.isNotBlank()
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
                    items(instructionsList, key = { it.first }) { pair ->
                        SwipeToDeleteContainer(
                            item = pair,
                            onDelete = { itemToDelete ->
                                instructionsList = instructionsList.filterNot { it.first == itemToDelete.first }
                            },
                            isDeletable = { it.first != instructionsList.first().first },
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .align(Alignment.CenterVertically),
                                    text = "${instructionsList.indexOf(pair) + 1}.",
                                    style = MaterialTheme.typography.headlineLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                OutlinedTextField(
                                    modifier = Modifier.weight(9f),
                                    value = pair.second,
                                    onValueChange = { newValue ->
                                        instructionsList = instructionsList.map {
                                            if (it.first == pair.first) it.copy(second = newValue) else it
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
                if (instructionsList.size == 2) {
                    Spacer(Modifier.size(4.dp))
                    Text(text = stringResource(R.string.remove_rows_by_swipe))
                }
            }
        }
    }
}