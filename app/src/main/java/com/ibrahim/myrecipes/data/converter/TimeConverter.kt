package com.ibrahim.myrecipes.data.converter

import android.content.Context
import com.ibrahim.myrecipes.R

fun Int.minutesToHourMinuteString(context: Context): String {
    val hours = this / 60
    val minutes = this % 60

    return when {
        hours > 0 && minutes > 0 -> "$hours hrs $minutes min"
        hours > 0 -> "$hours" + context.getString(R.string.time_converter_hours)
        minutes > 0 -> "$minutes" + context.getString(R.string.time_converter_minutes)
        else -> "0 min"
    }
}