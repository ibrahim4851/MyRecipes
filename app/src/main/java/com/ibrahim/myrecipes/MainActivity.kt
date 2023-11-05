package com.ibrahim.myrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ibrahim.myrecipes.presentation.navigation.ScreensNavigation
import com.ibrahim.myrecipes.presentation.ui.theme.MyRecipesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRecipesTheme {
                ScreensNavigation()
            }
        }
    }
}
