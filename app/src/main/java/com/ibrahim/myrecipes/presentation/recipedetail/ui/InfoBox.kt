package com.ibrahim.myrecipes.presentation.recipedetail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahim.myrecipes.R

@Composable
fun InfoBox(backgroundColor: Color, infoIcon: Painter, infoTitle: String, infoContent: String) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val boxWidth = screenWidth * 0.30f

    Box(
        modifier = Modifier
            .size(boxWidth)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(30.dp)
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                infoIcon,
                null,
                modifier = Modifier
                    .size(boxWidth * 0.5f),
                tint = Color.White
                )
            Text(text = infoTitle, color = Color.White)
            Text(text = infoContent, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
fun InfoBoxPreviewServing() {
    InfoBox(
        Color(0xFFED6E3A),
        painterResource(id = R.drawable.baseline_restaurant_menu_24),
        "Servings",
        "6"
    )
}

@Preview
@Composable
fun InfoBoxPreviewTime() {
    InfoBox(
        Color(0xFF0189C5),
        painterResource(id = R.drawable.outline_watch_24),
        "Time",
        "1 hour 20 minutes"
    )
}

@Preview
@Composable
fun InfoBoxPreviewCategory() {
    InfoBox(
        Color(0xFF8759AC),
        painterResource(id = R.drawable.baseline_restaurant_24),
        "Time",
        "Hamburger"
    )
}