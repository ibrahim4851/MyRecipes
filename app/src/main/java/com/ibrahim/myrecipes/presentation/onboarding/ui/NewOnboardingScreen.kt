package com.ibrahim.myrecipes.presentation.onboarding.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.presentation.navigation.Screen
import com.ibrahim.myrecipes.presentation.onboarding.viewmodel.OnboardingViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    viewModel: OnboardingViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val locale = context.resources.configuration.locales[0].language
    val isTurkish = locale.startsWith("tr")
    val pages = getPages(context)

    LaunchedEffect(key1 = true) {
        viewModel.prepopulateData(isTurkish)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val buttonsState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", context.getString(R.string.next))
                    1 -> listOf(context.getString(R.string.back), context.getString(R.string.next))
                    2 -> listOf(context.getString(R.string.back), context.getString(R.string.get_started))
                    else -> listOf("", "")
                }
            }
        }
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index], modifier = Modifier.height((LocalConfiguration.current.screenHeightDp*0.8).dp))
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PagerIndicator(
                modifier = Modifier.width(52.dp),
                pagesSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()
                if (buttonsState.value[0].isNotEmpty()) {
                    Button(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage - 1
                                )
                            }

                        }
                    ) {
                        Text(text = buttonsState.value[0])
                    }
                }
                Spacer(Modifier.size(8.dp))
                Button(
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == pages.size - 1) {
                                navController.navigate(Screen.HomeScreen.route) {
                                    popUpTo(Screen.OnBoardingScreen.route) {
                                        inclusive = true
                                    }
                                }
                            } else {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                ) {
                    Text(text = buttonsState.value[1])
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}