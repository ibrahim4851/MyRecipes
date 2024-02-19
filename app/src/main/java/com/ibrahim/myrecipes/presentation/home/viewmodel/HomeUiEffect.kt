package com.ibrahim.myrecipes.presentation.home.viewmodel

sealed class HomeUiEffect {
    data class ChangeLanguage(val languageCode: String) : HomeUiEffect()
}