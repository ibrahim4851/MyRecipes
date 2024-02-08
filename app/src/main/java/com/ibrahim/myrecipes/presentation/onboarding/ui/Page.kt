package com.ibrahim.myrecipes.presentation.onboarding.ui

import androidx.annotation.DrawableRes
import com.ibrahim.myrecipes.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Welcome to MyRecipes!",
        description = "Discover a world of flavors right at your fingertips! Get ready to dive into an endless array of recipes that will inspire your next culinary adventure.",
        image = R.drawable.pizza1
    ),
    Page(
        title = "Step-by-Step Cooking Guides",
        description = "Follow along with detailed instructions and high-quality photos. From novice cooks to seasoned chefs, our guides make cooking simple and enjoyable.",
        image = R.drawable.hamburgeronboarding
    ),
    Page(
        title = "Find Your Next Favorite Dish",
        description = "Easily search for recipes by ingredients, cuisine, or mood. Whether you're looking for a quick lunch or a gourmet dinner, finding the perfect recipe is just a tap away.",
        image = R.drawable.pancakeonboarding
    )
)