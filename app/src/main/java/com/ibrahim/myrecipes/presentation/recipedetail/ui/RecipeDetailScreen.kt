package com.ibrahim.myrecipes.presentation.recipedetail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.converter.minutesToHourMinuteString
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.presentation.recipedetail.viewmodel.RecipeDetailViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Green300
import com.ibrahim.myrecipes.presentation.ui.theme.Green900
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
                    .padding(10.dp)
            ) {

                InfoBoxGroup(recipe)
                Spacer(Modifier.size(8.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "Ingredients",
                        fontWeight = FontWeight.Bold,
                        style = Typography.headlineSmall
                    )
                }
                Spacer(Modifier.size(8.dp))
                LazyColumn(content = {
                    itemsIndexed(ingredients) { index, ingredient ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(text = "${(index + 1)}")
                            Spacer(modifier = Modifier.padding(4.dp))
                            Text(text = ingredient.ingredientName)
                        }
                    }
                })
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "Instructions",
                        fontWeight = FontWeight.Bold,
                        style = Typography.headlineSmall
                    )
                }
                Spacer(Modifier.size(8.dp))
                LazyColumn(content = {
                    itemsIndexed(recipe.recipeInstructions) { index, instruction ->
                        ExpandableCard(title = "${(index + 1)}. step", description = instruction)
                        Spacer(Modifier.size(8.dp))
                    }
                })
            }
        }
    }
}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun RecipeDetailHeader(progress: Float) {
    Spacer(
        modifier = Modifier
            .height(280.dp)
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
            .background(Color.White)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = recipe.recipeTitle,
            style = MaterialTheme.typography.displayMedium,
            modifier = HzPadding
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

        Spacer(Modifier.height(MinTitleOffset + 42.dp))
        Divider()
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
            infoTitle = "Servings",
            infoContent = recipe.recipeServings.toString()
        )
        InfoBox(
            backgroundColor = Color(0xFF0189C5),
            infoIcon = painterResource(id = R.drawable.outline_watch_24),
            infoTitle = "Time",
            infoContent = recipe.recipeTime.minutesToHourMinuteString()
        )
        InfoBox(
            backgroundColor = Color(0xFF8759AC),
            infoIcon = painterResource(id = R.drawable.baseline_restaurant_menu_24),
            infoTitle = "Category",
            infoContent = recipe.foodCategory.value
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

@Preview
@Composable
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(navController = rememberNavController())
}
