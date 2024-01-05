package com.ibrahim.myrecipes.data.converter

fun Int.minutesToHourMinuteString(): String {
    val hours = this / 60
    val minutes = this % 60

    return when {
        hours > 0 && minutes > 0 -> "$hours hrs $minutes min"
        hours > 0 -> "$hours hrs"
        minutes > 0 -> "$minutes min"
        else -> "0 min"
    }
}