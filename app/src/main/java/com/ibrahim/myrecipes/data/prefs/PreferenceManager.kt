package com.ibrahim.myrecipes.data.prefs

import android.content.Context
import android.content.SharedPreferences
import java.util.Locale

class PreferenceManager(context: Context) {
    companion object {
        private const val PREFS_FILE_NAME = "prefs"
        private const val LANGUAGE_KEY = "language"
        private const val IS_INFO_GIVEN = "info"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)

    fun saveLanguagePreference(languageCode: String) {
        sharedPreferences.edit().putString(LANGUAGE_KEY, languageCode).apply()
    }

    fun saveInfoGivenRecord() {
        sharedPreferences.edit().putBoolean(IS_INFO_GIVEN, true).apply()
    }

    fun getInfoGivenRecord(): Boolean {
        return sharedPreferences.getBoolean(IS_INFO_GIVEN, false)
    }


    fun getLanguagePreference(): String? =
        sharedPreferences.getString(LANGUAGE_KEY, Locale.getDefault().language)
}
