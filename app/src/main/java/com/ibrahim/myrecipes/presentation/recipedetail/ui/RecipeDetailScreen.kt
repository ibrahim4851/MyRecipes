package com.ibrahim.myrecipes.presentation.recipedetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.presentation.recipedetail.viewmodel.RecipeDetailViewModel

@Composable
fun RecipeDetailScreen(
    navController: NavController,
    viewModel: RecipeDetailViewModel = hiltViewModel()
) {

    val screenWidth: Int = LocalConfiguration.current.screenWidthDp
    val recipe = viewModel.state.value.recipe

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    AsyncImage(
                        model = viewModel.state.value.recipe.recipePhotoUri,
                        modifier = Modifier.offset(y = 35.dp),
                        contentDescription = null
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                InfoBoxGroup(recipe)
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(recipe.recipeTitle, fontWeight = FontWeight.Bold)
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("Instructions")
                }
                LazyColumn(content = {
                    itemsIndexed(recipe.recipeInstructions) { index, instruction ->
                        ExpandableCard(title = "$index. step", description = instruction)
                    }
                })
            }
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
            infoTitle = "Servings",
            infoContent = recipe.recipeServings.toString()
        )
        InfoBox(
            backgroundColor = Color(0xFF0189C5),
            infoIcon = painterResource(id = R.drawable.baseline_restaurant_menu_24),
            infoTitle = "Time",
            infoContent = recipe.recipeTime.toString()
        )
        InfoBox(
            backgroundColor = Color(0xFF8759AC),
            infoIcon = painterResource(id = R.drawable.baseline_restaurant_menu_24),
            infoTitle = "Category",
            infoContent = recipe.foodCategory.value
        )
    }
}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun RecipeDetailHeader(progress: Float) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.recipe_detail)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}