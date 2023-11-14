package com.ibrahim.myrecipes.presentation.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahim.myrecipes.R

@Composable
@Preview
fun OverlappingImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Cyan)
    )
    {

        Image(
            painter = painterResource(id = R.drawable.pizza1),
            null,
            modifier = Modifier
                .width(150.dp)
                .align(Alignment.TopEnd)
        )
        Image(
            painter = painterResource(id = R.drawable.hamburger),
            null,
            modifier = Modifier
                .wrapContentSize(
                    align = Alignment.TopStart,
                    unbounded = true
                )
                .align(Alignment.TopEnd)
        )


    }
}