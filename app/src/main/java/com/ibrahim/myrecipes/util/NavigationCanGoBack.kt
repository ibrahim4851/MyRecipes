package com.ibrahim.myrecipes.util

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController

val NavController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED