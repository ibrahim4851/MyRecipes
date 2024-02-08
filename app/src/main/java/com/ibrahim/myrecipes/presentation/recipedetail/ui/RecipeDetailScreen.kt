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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.converter.minutesToHourMinuteString
import com.ibrahim.myrecipes.data.enums.getLabel
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.domain.repository.Ingredients
import com.ibrahim.myrecipes.presentation.recipedetail.viewmodel.RecipeDetailViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Green300
import com.ibrahim.myrecipes.presentation.ui.theme.Green900
import com.ibrahim.myrecipes.presentation.ui.theme.Pistachio
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import kotlin.math.max
import kotlin.math.min


private val BottomBarHeight = 56.dp
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
fun RecipeDetailScreen(
    navController: NavController,
    viewModel: RecipeDetailViewModel = hiltViewModel()
) {

    val scrollState = rememberScrollState(0)
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val imageSize = screenWidth * 0.5f

    val recipe = viewModel.state.value.recipe
    val ingredients = viewModel.state.value.ingredients

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Box(Modifier.fillMaxWidth()) {
                    RecipeDetailHeader()
                    Body(scroll = scrollState, recipe = recipe, ingredients = ingredients)
                    RecipeTitleObject(scrollProvider = { scrollState.value }, recipe = recipe)
                    RecipeImageObject(scrollProvider = { scrollState.value }, recipe = recipe)
                }
            }
        }
    }
}

@Composable
fun Body(scroll: ScrollState, recipe: Recipe, ingredients: Ingredients) {
    Column(Modifier.fillMaxWidth()) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier
                .verticalScroll(scroll)
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Spacer(Modifier.height(GradientScroll))
            Spacer(Modifier.height(ImageOverlap))
            Spacer(Modifier.height(TitleHeight))
            Spacer(Modifier.height(16.dp))
            Spacer(Modifier.height(60.dp))
            Spacer(Modifier.size(8.dp))
            InfoBoxGroup(recipe)
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    stringResource(R.string.ingredients),
                    fontWeight = FontWeight.Bold,
                    style = Typography.headlineLarge
                )
            }
            Spacer(Modifier.size(8.dp))
            AnimatedBorderCard(gradient = Brush.linearGradient(listOf(Pistachio, Green900))) {
                Column(Modifier.padding(8.dp)) {
                    repeat(ingredients.size) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = ingredients[it].ingredientQuantity.toString() +
                                        " " +
                                        ingredients[it].ingredientQuantityUnit.getLabel() +
                                        " " +
                                        ingredients[it].ingredientName,
                                style = Typography.titleLarge
                            )
                        }
                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.instructions),
                    fontWeight = FontWeight.Bold,
                    style = Typography.headlineLarge
                )
            }
            Spacer(Modifier.size(8.dp))
            repeat(recipe.recipeInstructions.size) {
                ExpandableCard(
                    title = "${(it + 1)}. step",
                    description = recipe.recipeInstructions[it]
                )
                Spacer(Modifier.size(8.dp))
            }
        }
    }
}

@Composable
fun RecipeDetailHeader() {
    Spacer(
        modifier = Modifier
            .height(240.dp)
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    listOf(
                        Color(Green300.value),
                        Color(Green900.value)
                    )
                )
            )
    )
}

@Composable
fun RecipeImageObject(scrollProvider: () -> Int, recipe: Recipe) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFractionProvider = {
        (scrollProvider() / collapseRange).coerceIn(0f, 1f)
    }
    CollapsingImageLayout(
        collapseFractionProvider = collapseFractionProvider,
        modifier = HzPadding.statusBarsPadding()
    ) {
        AsyncImage(
            model = recipe.recipePhotoUri,
            modifier = Modifier.clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
fun RecipeTitleObject(scrollProvider: () -> Int, recipe: Recipe) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
    val textStyleHeadline1 = MaterialTheme.typography.headlineSmall.copy(fontSize = 42.sp, lineHeight = 45.sp)
    var textStyle by remember { mutableStateOf(textStyleHeadline1) }
    var readyToDraw by remember { mutableStateOf(false) }

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
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                text = recipe.recipeTitle,
                style = textStyle,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                onTextLayout = { textLayoutResult ->
                    if (textLayoutResult.didOverflowWidth) {
                        textStyle = textStyle.copy(fontSize = textStyle.fontSize * 0.9)
                    } else {
                        readyToDraw = true
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .width((LocalConfiguration.current.screenWidthDp * 0.55).dp)
                    .drawWithContent {
                        if(readyToDraw) drawContent()
                    }
            )
            Text(
                text = "Test Tagline",
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 20.sp,
                modifier = HzPadding
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = recipe.foodCategory.name,
                style = MaterialTheme.typography.titleSmall,
                modifier = HzPadding
            )
            Spacer(Modifier.height(7.dp))
            Divider()
        }
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
            (constraints.maxWidth - imageWidth) / 2, // centered when expanded
            constraints.maxWidth - imageWidth, // right aligned when collapsed
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
private fun InfoBoxGroup(recipe: Recipe) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        InfoBox(
            backgroundColor = Color(0xFFED6E3A),
            infoIcon = painterResource(id = R.drawable.baseline_restaurant_menu_24),
            infoTitle = stringResource(R.string.servings),
            infoContent = recipe.recipeServings.toString()
        )
        InfoBox(
            backgroundColor = Color(0xFF0189C5),
            infoIcon = painterResource(id = R.drawable.outline_watch_24),
            infoTitle = stringResource(R.string.time),
            infoContent = recipe.recipeTime.minutesToHourMinuteString(LocalContext.current)
        )
        InfoBox(
            backgroundColor = Color(0xFF8759AC),
            infoIcon = painterResource(id = R.drawable.baseline_restaurant_menu_24),
            infoTitle = stringResource(R.string.category),
            infoContent = recipe.foodCategory.getLabel()
        )
    }
}

@Preview
@Composable
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(navController = rememberNavController())
}
