package com.ibrahim.myrecipes.presentation.onboarding.ui

import android.content.Context
import androidx.annotation.DrawableRes
import com.ibrahim.myrecipes.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)
fun getPages(context: Context): List<Page> {
    return listOf(
        Page(
            title = context.getString(R.string.onboarding_title_1),
            description = context.getString(R.string.onboarding_content_1),
            image = R.drawable.pizza1
        ),
        Page(
            title = context.getString(R.string.onboarding_title_2),
            description = context.getString(R.string.onboarding_content_2),
            image = R.drawable.hamburgeronboarding
        ),
        Page(
            title = context.getString(R.string.onboarding_title_3),
            description = context.getString(R.string.onboarding_content_3),
            image = R.drawable.pancakeonboarding
        )
    )
}