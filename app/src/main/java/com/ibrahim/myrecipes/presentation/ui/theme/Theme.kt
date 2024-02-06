package com.ibrahim.myrecipes.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Green900,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color.Black,
    surface = GreenDarkBackground,
    onPrimary = Pistachio,
    onSecondary = Pistachio,
    onTertiary = Pistachio,
    onBackground = Pistachio,
    onSurface = Pistachio,
    onPrimaryContainer = Green200, //fab icon color
    primaryContainer = GreenDarkerBackground, //fab backgrond
    outline = Pistachio,
    secondaryContainer = Green200, //chip selected
    onSurfaceVariant = Pistachio,// chip text color
    onSecondaryContainer = Color.Black, // selected chip text color
    surfaceVariant = Green200
)

private val LightColorScheme = lightColorScheme(
    primary = Green600,
    secondary = Green700,
    tertiary = Pink40,
    background = Color.White,
    surface = Green50,
    surfaceTint = Green900,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    onPrimaryContainer = Color.White, //fab icon color
    primaryContainer = Green400, //fab backgrond
    secondaryContainer = Green200, //chip selected
    onSurfaceVariant = Color.Black,// chip text color
    onSecondaryContainer = Color.Black, // selected chip text color
    surfaceVariant = Green200
)


@Composable
fun MyRecipesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}