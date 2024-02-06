package com.ibrahim.myrecipes.presentation.home.ui

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.converter.minutesToHourMinuteString
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeItem(
    recipe: Recipe,
    onRecipeItemClick: (Recipe) -> Unit
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
                    onRecipeItemClick(recipe)
                }
            )
    ) {
        Box {
            AsyncImage(
                model = uri,
                null
            )
            if(showDeleteButton) {
                IconButton(
                    onClick = { },
                    Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
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
                            modifier = Modifier.size(20.dp)
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
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
            }

        }

    }
}