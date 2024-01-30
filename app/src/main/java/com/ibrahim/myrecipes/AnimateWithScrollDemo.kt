package com.ibrahim.myrecipes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun AnimateWithScroll() {
    // Remember the lazy list state to track the scroll position
    val listState = rememberLazyListState()
    // Determine the position of the first visible item
    val firstVisibleItemIndex by remember {
        derivedStateOf { listState.firstVisibleItemIndex }
    }
    val firstVisibleItemScrollOffset by remember {
        derivedStateOf { listState.firstVisibleItemScrollOffset }
    }

    // Calculate the scale and alpha based on the scroll position
    val scale by remember {
        derivedStateOf {
            min(1f, 1f - (firstVisibleItemScrollOffset / 1000f))
        }
    }
    val alpha by remember {
        derivedStateOf {
            min(1f, 1f - (firstVisibleItemScrollOffset / 1000f))
        }
    }

    Column(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.pizza1),
            contentDescription = "Animated Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .graphicsLayer {
                    this.scaleX = scale
                    this.scaleY = scale
                    this.alpha = alpha
                }
        )
        LazyColumn(state = listState) {
            items(100) { index ->
                Text(
                    "Item $index", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }


}
