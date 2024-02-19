package com.ibrahim.myrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ibrahim.myrecipes.data.prefs.PreferenceManager
import com.ibrahim.myrecipes.presentation.navigation.ScreensNavigation
import com.ibrahim.myrecipes.presentation.ui.theme.MyRecipesTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applyLanguage()
        setContent {
            MyRecipesTheme {
                ScreensNavigation()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        applyLanguage()
    }

    private fun applyLanguage() {
        val languageCode = PreferenceManager(this).getLanguagePreference() ?: return
        changeLocaleAndRecreate(languageCode, applyOnly = true)
    }

    fun changeLocaleAndRecreate(languageCode: String, applyOnly: Boolean = false) {
        PreferenceManager(this).saveLanguagePreference(languageCode)
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        if (!applyOnly) {
            recreate()
        }
    }

}
