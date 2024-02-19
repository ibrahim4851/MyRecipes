package com.ibrahim.myrecipes.presentation.recipedetail.ui

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.core.os.ConfigurationCompat
import androidx.core.os.LocaleListCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.converter.minutesToHourMinuteString
import com.ibrahim.myrecipes.data.enums.getLabel
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.Ingredients
import com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog.AddIngredientDialog
import com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog.AddInstructionDialog
import com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog.UpdateCategoryDialog
import com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog.UpdateIngredientDialog
import com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog.UpdateInstructionDialog
import com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog.UpdateServingAndTimeDialog
import com.ibrahim.myrecipes.presentation.recipedetail.ui.updatedialog.UpdateTitleDialog
import com.ibrahim.myrecipes.presentation.recipedetail.viewmodel.RecipeDetailEvent
import com.ibrahim.myrecipes.presentation.recipedetail.viewmodel.RecipeDetailViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import com.ibrahim.myrecipes.presentation.ui.theme.themedGradient
import com.ibrahim.myrecipes.util.appendEmojiIfAny
import com.ibrahim.myrecipes.util.canGoBack
import com.ibrahim.myrecipes.util.emojiMapEnglish
import com.ibrahim.myrecipes.util.emojiMapTurkish
import java.util.Locale
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
private val HzPadding = Modifier.padding(horizontal = 12.dp)

@Composable
fun RecipeDetail(
    navController: NavController,
    viewModel: RecipeDetailViewModel = hiltViewModel()
) {
    val recipe = viewModel.state.value.recipe
    val ingredients = viewModel.state.value.ingredients
    val context = LocalContext.current
    val isFirstLaunch = viewModel.state.value.isFirstLaunch

    LaunchedEffect(isFirstLaunch) {
        if (isFirstLaunch) {
            Toast.makeText(context, "You can edit anything by clicking on it.", Toast.LENGTH_LONG).show()
            viewModel.onFirstLaunchComplete()
        }
    }

    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        Body(recipe, ingredients, scroll, viewModel)
        Title(recipe, { scroll.value }, ingredients = ingredients, viewModel)
        Image(recipe.recipePhotoUri!!) { scroll.value }
        BackButton {
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
            .background(themedGradient())
    )
}

@Composable
private fun BackButton(upPress: () -> Unit) {
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
    scroll: ScrollState,
    viewModel: RecipeDetailViewModel
) {
    val currentLanguage = getLocale().language
    val emojiMap = if (currentLanguage == "tr") emojiMapTurkish else emojiMapEnglish
    val isTurkish = currentLanguage == "tr"
    var showAddInstructionDialog by remember { mutableStateOf(false) }
    var showAddIngredientDialog by remember { mutableStateOf(false) }

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
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.ingredients) + " (+)",
                        style = Typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = HzPadding
                            .clickable(
                                enabled = true,
                                onClick = {
                                    showAddIngredientDialog = !showAddIngredientDialog
                                })
                    )
                    Spacer(Modifier.size(8.dp))
                    repeat(ingredients.size) {
                        val ingredient = ingredients[it]
                        val ingredientNameWithEmoji =
                            appendEmojiIfAny(ingredient.ingredientName, emojiMap, isTurkish)

                        val ingredientText = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 19.sp
                                )
                            ) {
                                append("• ")
                                append(ingredient.ingredientQuantity.toString())
                                append(" ")
                                append(ingredient.ingredientQuantityUnit.getLabel())
                            }
                            append(" ")
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Light,
                                    fontSize = 19.sp
                                )
                            ) {
                                append(ingredientNameWithEmoji)
                            }
                        }

                        var showUpdateIngredientDialog by remember { mutableStateOf(false) }

                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = ingredientText,
                                style = Typography.titleLarge,
                                modifier = HzPadding
                                    .padding(vertical = 8.dp)
                                    .clickable(
                                        enabled = true,
                                        onClick = {
                                            showUpdateIngredientDialog = !showUpdateIngredientDialog
                                        })
                            )
                        }

                        if (showAddIngredientDialog) {
                            AddIngredientDialog(
                                onDismissRequest = { showAddIngredientDialog = false },
                                onConfirmation = { newIngredient ->
                                    viewModel.onEvent(
                                        RecipeDetailEvent.AddIngredientEvent(
                                            newIngredient
                                        )
                                    )
                                    showAddIngredientDialog = false
                                },
                                dialogTitle = stringResource(R.string.add_new_ingredient),
                                recipeId = recipe.recipeId,
                                icon = Icons.Filled.Edit
                            )
                        }

                        if (showUpdateIngredientDialog) {
                            UpdateIngredientDialog(
                                onDismissRequest = { showUpdateIngredientDialog = false },
                                onConfirmation = { newIngredient ->
                                    viewModel.onEvent(
                                        RecipeDetailEvent.UpdateIngredientEvent(
                                            newIngredient
                                        )
                                    )
                                    showUpdateIngredientDialog = false
                                },
                                onDelete = {
                                    viewModel.onEvent(
                                        RecipeDetailEvent.DeleteIngredientEvent(
                                            ingredient.ingredientId
                                        )
                                    )
                                },
                                dialogTitle = stringResource(R.string.update_the_ingredient),
                                initialIngredient = ingredient,
                                icon = Icons.Filled.Edit
                            )
                        }

                        if (showAddInstructionDialog) {
                            AddInstructionDialog(
                                onDismissRequest = { showAddInstructionDialog = false },
                                onConfirmation = { newInstruction ->
                                    viewModel.onEvent(
                                        RecipeDetailEvent.AddInstructionEvent(
                                            newInstruction
                                        )
                                    )
                                    showAddInstructionDialog = false
                                },
                                dialogTitle = stringResource(R.string.add_new_instruction),
                                icon = Icons.Filled.Edit
                            )
                        }

                    }

                    Spacer(Modifier.height(20.dp))
                    Divider()
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.instructions) + " (+)",
                        fontWeight = FontWeight.Bold,
                        style = Typography.headlineMedium,
                        modifier = HzPadding.clickable(
                            enabled = true,
                            onClick = {
                                showAddInstructionDialog = !showAddInstructionDialog
                            })
                    )

                    Spacer(Modifier.size(8.dp))
                    repeat(recipe.recipeInstructions.size) {
                        val instruction = recipe.recipeInstructions[it]
                        val position = it
                        var showUpdateInstructionDialog by remember { mutableStateOf(false) }
                        Text(
                            text = instruction,
                            HzPadding.clickable(
                                enabled = true,
                                onClick = {
                                    showUpdateInstructionDialog = !showUpdateInstructionDialog
                                }),
                            style = Typography.titleMedium.copy(
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Light
                            )
                        )


                        if (showUpdateInstructionDialog) {
                            UpdateInstructionDialog(
                                onDismissRequest = { showUpdateInstructionDialog = false },
                                onConfirmation = { newInstruction ->
                                    viewModel.onEvent(
                                        RecipeDetailEvent.UpdateInstructionEvent(
                                            newInstruction,
                                            position
                                        )
                                    )
                                    showUpdateInstructionDialog = false
                                },
                                dialogTitle = stringResource(R.string.update_the_instruction),
                                instruction = instruction,
                                onDelete = {
                                    viewModel.onEvent(
                                        RecipeDetailEvent.DeleteInstructionEvent(
                                            position
                                        )
                                    )
                                },
                                icon = Icons.Filled.Edit
                            )
                        }

                        Spacer(Modifier.size(8.dp))
                        Spacer(Modifier.size(8.dp))
                    }
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}


@Composable
private fun Title(
    recipe: Recipe,
    scrollProvider: () -> Int,
    ingredients: Ingredients,
    viewModel: RecipeDetailViewModel
) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
    var showUpdateTitleDialog by remember { mutableStateOf(false) }
    var showUpdateCategoryDialog by remember { mutableStateOf(false) }
    var showUpdateTimeAndServingDialog by remember { mutableStateOf(false) }

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

        if (showUpdateTitleDialog) {
            UpdateTitleDialog(
                onDismissRequest = { showUpdateTitleDialog = false },
                onConfirmation = { updatedTitle ->
                    viewModel.onEvent(RecipeDetailEvent.UpdateRecipeTitleEvent(updatedTitle))
                    showUpdateTitleDialog = false
                },
                dialogTitle = stringResource(R.string.update_recipe_title),
                recipeTitle = recipe.recipeTitle,
                icon = Icons.Filled.Edit
            )
        }

        if (showUpdateCategoryDialog) {
            UpdateCategoryDialog(
                onDismissRequest = { showUpdateCategoryDialog = false },
                onConfirmation = { selectedCategory ->
                    viewModel.onEvent(
                        RecipeDetailEvent.UpdateFoodCategoryEvent(
                            foodCategory = selectedCategory
                        )
                    )
                    showUpdateCategoryDialog = false
                },
                dialogTitle = stringResource(R.string.update_recipe_category),
                initialCategory = recipe.foodCategory,
                icon = Icons.Filled.Edit
            )
        }

        if (showUpdateTimeAndServingDialog) {
            UpdateServingAndTimeDialog(
                onDismissRequest = { showUpdateTimeAndServingDialog = false },
                onConfirmation = { updatedServings, updatedTime ->
                    viewModel.onEvent(
                        RecipeDetailEvent.UpdateServingsAndTimeEvent(
                            updatedServings,
                            updatedTime
                        )
                    )
                    showUpdateTimeAndServingDialog = false
                },
                dialogTitle = stringResource(R.string.update_time_servings),
                recipeTime = recipe.recipeTime,
                recipeServings = recipe.recipeServings,
                icon = Icons.Filled.Edit
            )
        }

        Text(
            text = recipe.recipeTitle,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = HzPadding
                .width((LocalConfiguration.current.screenWidthDp * 0.55).dp)
                .clickable(
                    enabled = true,
                    onClick = { showUpdateTitleDialog = !showUpdateTitleDialog })
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = recipe.recipeTime.minutesToHourMinuteString(LocalContext.current) + " | " + recipe.recipeServings + " " + stringResource(
                id = R.string.servings
            ),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp,
            modifier = HzPadding.clickable(
                enabled = true,
                onClick = {
                    showUpdateTimeAndServingDialog = !showUpdateTimeAndServingDialog
                }
            )
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = recipe.foodCategory.getLabel(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = HzPadding.clickable(
                enabled = true,
                onClick = { showUpdateCategoryDialog = !showUpdateCategoryDialog })
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

@Composable
@ReadOnlyComposable
fun getLocale(): Locale {
    val configuration = LocalConfiguration.current
    return ConfigurationCompat.getLocales(configuration).get(0)
        ?: LocaleListCompat.getDefault()[0]!!
}


