package com.ibrahim.myrecipes.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {

    val horizontalPagerState = rememberPagerState(pageCount = { 3 })
    val horizontalPagerHeight = LocalConfiguration.current.screenHeightDp * 0.7
    val lottieAnimationWidth = LocalConfiguration.current.screenWidthDp * 0.7
    val horizontalPagerWidth = LocalConfiguration.current.screenWidthDp * 0.98

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    HorizontalPager(
                        state = horizontalPagerState,
                        Modifier
                            .height(horizontalPagerHeight.dp)
                            .width(horizontalPagerWidth.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        when (horizontalPagerState.currentPage) {
                            0 -> {
                                Column(Modifier.fillMaxWidth()) {

                                    val composition1 by rememberLottieComposition(
                                        LottieCompositionSpec.RawRes(R.raw.animation1)
                                    )
                                    LottieAnimation(
                                        composition = composition1,
                                        Modifier
                                            .size(lottieAnimationWidth.dp)
                                            .align(Alignment.CenterHorizontally),
                                        iterations = LottieConstants.IterateForever
                                    )
                                    Column(Modifier.padding(8.dp)) {
                                        Text(
                                            text = "Welcome to MyRecipes!",
                                            style = Typography.displaySmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(Modifier.size(18.dp))
                                        Text(
                                            style = Typography.titleLarge,
                                            text = "Discover a world of flavors right at your fingertips! Get ready to dive into an endless array of recipes that will inspire your next culinary adventure.",
                                        )
                                    }
                                }
                            }

                            1 -> {
                                Column(Modifier.fillMaxWidth()) {

                                    val composition2 by rememberLottieComposition(
                                        LottieCompositionSpec.RawRes(R.raw.animation2)
                                    )
                                    LottieAnimation(
                                        composition = composition2,
                                        Modifier
                                            .size(lottieAnimationWidth.dp)
                                            .align(Alignment.CenterHorizontally),
                                        iterations = LottieConstants.IterateForever
                                    )

                                    Column(Modifier.padding(8.dp)) {
                                        Text(
                                            text = "Step-by-Step Cooking Guides",
                                            style = Typography.displaySmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(Modifier.size(18.dp))
                                        Text(
                                            style = Typography.titleLarge,
                                            text = "Follow along with detailed instructions and high-quality photos. From novice cooks to seasoned chefs, our guides make cooking simple and enjoyable."
                                        )
                                    }
                                }
                            }

                            2 -> {
                                Column(Modifier.fillMaxWidth()) {

                                    val composition3 by rememberLottieComposition(
                                        LottieCompositionSpec.RawRes(R.raw.animation3)
                                    )
                                    LottieAnimation(
                                        composition = composition3,
                                        Modifier
                                            .size(lottieAnimationWidth.dp)
                                            .align(Alignment.CenterHorizontally),
                                        iterations = LottieConstants.IterateForever
                                    )
                                    Column(Modifier.padding(8.dp)) {
                                        Text(
                                            text = "Find Your Next Favorite Dish",
                                            style = Typography.displaySmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(Modifier.size(18.dp))
                                        Text(
                                            style = Typography.titleLarge,
                                            text = "Easily search for recipes by ingredients, cuisine, or mood. Whether you're looking for a quick lunch or a gourmet dinner, finding the perfect recipe is just a tap away."
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Row(
                        Modifier.padding(18.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(" ")
                        OutlinedButton(onClick = {
                            navController.navigate(Screen.HomeScreen.route)
                        }
                        ) {
                            Text(stringResource(R.string.ok))
                        }
                    }
                }
                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(horizontalPagerState.pageCount) { iteration ->
                        val color =
                            if (horizontalPagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(16.dp)
                        )
                    }
                }
            }
        }
    }
}