package com.ibrahim.myrecipes.presentation.home

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.domain.model.Recipe
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun RecipeItem(
    recipe: Recipe = Recipe(
        recipeId = 1,
        recipeTitle = "Delicious Burger",
        recipeDescription = "A mouthwatering burger recipe",
        recipeInstructions = "1. Grill the burger patties...\n2. Toast the buns...\n3. Assemble the burger...",
        recipeTime = 30,
        recipeServings = 2,
        foodCategory = FoodCategory.BURGER,
        recipePhotoUri = "https://example.com/burger.jpg" // URL to the recipe photo, can be null
    )
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        AsyncImage(
            model = Uri.parse("file://${recipe.recipePhotoUri}"),
            null
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = recipe.recipeTitle,
                fontWeight = FontWeight.Bold,
                style = Typography.titleMedium
            )

            Column {

                AssistChip(
                    modifier = Modifier.padding(bottom = 0.dp),
                    onClick = { /*TODO*/ },
                    label = {
                        Text(
                            text = (recipe.recipeServings.toString() + " sv.")
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
                    onClick = { /*TODO*/ },
                    label = {
                        Text(
                            text = (recipe.recipeTime.toString() + " mn.")
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