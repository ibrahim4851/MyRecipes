package com.ibrahim.myrecipes.presentation.recipe.recipedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxExperiment() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val seventyPercentScreenHeight = (screenHeight * 0.7f)

    Column {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(seventyPercentScreenHeight)
                    .align(Alignment.BottomEnd)
                    .background(color = Color.Green, shape = RoundedCornerShape(topStart = 36.dp)))
                    {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max),
                        ) {
                            Text(text = "A", modifier = Modifier.height(seventyPercentScreenHeight - 50.dp))
                        }
                    }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun BoxExperimanPrev() {
    BoxExperiment()
}