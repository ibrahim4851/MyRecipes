/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibrahim.myrecipes.presentation.recipedetail.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.enums.getLabel
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.Ingredients
import com.ibrahim.myrecipes.presentation.recipedetail.viewmodel.RecipeDetailViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Green900
import com.ibrahim.myrecipes.presentation.ui.theme.Lime
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import com.ibrahim.myrecipes.util.canGoBack
import kotlin.math.max
import kotlin.math.min

private val TitleHeight = 128.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 56.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 150.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun SnackDetail(
    navController: NavController,
    viewModel: RecipeDetailViewModel = hiltViewModel()
) {
    val recipe = viewModel.state.value.recipe
    val ingredients = viewModel.state.value.ingredients

    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        Body(recipe, ingredients, scroll)
        Title(recipe) { scroll.value }
        Image(recipe.recipePhotoUri!!) { scroll.value }
        Up {
            if (navController.canGoBack) {
                navController.popBackStack()
            }
        }
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(Brush.horizontalGradient(listOf(Green900, Lime)))
    )
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = null
        )
    }
}

@Composable
private fun Body(
    recipe: Recipe,
    ingredients: Ingredients,
    scroll: ScrollState
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(GradientScroll))
            Surface(Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.background) {
                Column {
                    Spacer(Modifier.height(ImageOverlap))
                    Spacer(Modifier.height(TitleHeight))

                    Spacer(Modifier.height(16.dp))
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = "Ingredients",
                        style = Typography.headlineSmall,
                        modifier = HzPadding
                    )
                    repeat(ingredients.size) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = ingredients[it].ingredientQuantity.toString() +
                                        " " +
                                        ingredients[it].ingredientQuantityUnit.getLabel() +
                                        " " +
                                        ingredients[it].ingredientName,
                                style = Typography.titleLarge,
                                modifier = HzPadding
                            )
                        }
                    }
                    Spacer(Modifier.height(40.dp))
                    Divider()
                    Text(
                        text = "Instructions",
                        style = Typography.headlineSmall,
                        modifier = HzPadding
                    )
                    repeat(recipe.recipeInstructions.size) {
                        val instruction = recipe.recipeInstructions[it]
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = instruction,
                                style = Typography.titleLarge,
                                modifier = HzPadding
                            )
                        }
                    }
                    Text(
                        text = stringResource(R.string.ingredients),
                        style = Typography.labelLarge,
                        modifier = HzPadding
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "stringResource",
                        style = Typography.bodySmall,
                        modifier = HzPadding
                    )

                    Spacer(Modifier.height(16.dp))

                }
            }
        }
    }
}

@Composable
private fun Title(recipe: Recipe, scrollProvider: () -> Int) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .offset {
                val scroll = scrollProvider()
                val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
                IntOffset(x = 0, y = offset.toInt())
            }
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = recipe.recipeTitle,
            style = MaterialTheme.typography.headlineMedium,
            maxLines = 2,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = HzPadding.width((LocalConfiguration.current.screenWidthDp * 0.55).dp)
        )
        Text(
            text = "Test Tagline",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp,
            modifier = HzPadding
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = recipe.foodCategory.getLabel(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = HzPadding
        )

        Spacer(Modifier.height(8.dp))
        Divider()
    }
}

@Composable
private fun Image(
    imageUrl: String,
    scrollProvider: () -> Int
) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFractionProvider = {
        (scrollProvider() / collapseRange).coerceIn(0f, 1f)
    }

    CollapsingImageLayout(
        collapseFractionProvider = collapseFractionProvider,
        modifier = HzPadding.statusBarsPadding()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .allowHardware(false)
                .build(),
            contentDescription = null,
            modifier = Modifier.clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun CollapsingImageLayout(
    collapseFractionProvider: () -> Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        check(measurables.size == 1)

        val collapseFraction = collapseFractionProvider()

        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = lerp(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidth, imageWidth))

        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = lerp(
            (constraints.maxWidth - imageWidth) / 2,
            constraints.maxWidth - imageWidth,
            collapseFraction
        )
        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth
        ) {
            imagePlaceable.placeRelative(imageX, imageY)
        }
    }
}