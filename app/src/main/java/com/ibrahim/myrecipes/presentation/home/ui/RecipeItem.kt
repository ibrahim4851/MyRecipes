package com.ibrahim.myrecipes.presentation.home.ui

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.converter.minutesToHourMinuteString
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeItem(
    recipe: Recipe,
    modifier: Modifier,
    onRecipeItemClick: (Recipe) -> Unit,
    onDeleteClick: (Recipe) -> Unit
) {
    val uri = Uri.parse(recipe.recipePhotoUri)
    val haptics = LocalHapticFeedback.current
    var showDeleteButton by remember { mutableStateOf(false) }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .combinedClickable(
                enabled = true,
                onLongClick = {
                    haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                    showDeleteButton = !showDeleteButton
                },
                onClick = {
                    if (showDeleteButton) {
                        showDeleteButton = !showDeleteButton
                    } else {
                        onRecipeItemClick(recipe)
                    }
                }
            )
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(uri)
                    .allowHardware(false)
                    .build(),
                null
            )
            if (showDeleteButton) {
                IconButton(
                    onClick = {
                        onDeleteClick(recipe)
                        showDeleteButton = false
                              },
                    Modifier.align(Alignment.TopEnd).background(
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    )
                ) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = null, tint = Color.Red)
                }
            }
        }

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = recipe.recipeTitle,
                fontWeight = FontWeight.Bold,
                style = Typography.titleLarge
            )

            Column {

                AssistChip(
                    modifier = Modifier.padding(bottom = 0.dp),
                    onClick = { },
                    label = {
                        Text(
                            text = (recipe.recipeServings.toString() + stringResource(R.string.recipe_recipe_servings))
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.baseline_serving_24),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = MaterialTheme.colorScheme.secondaryContainer
                        )
                    }
                )
                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = (recipe.recipeTime.minutesToHourMinuteString(LocalContext.current))
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.baseline_watch_later_24),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = MaterialTheme.colorScheme.secondaryContainer
                        )
                    }
                )
            }
        }
    }
}