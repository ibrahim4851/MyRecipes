package com.ibrahim.myrecipes.util

import java.util.Locale

fun String.formatString(): String = this.lowercase()
    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }