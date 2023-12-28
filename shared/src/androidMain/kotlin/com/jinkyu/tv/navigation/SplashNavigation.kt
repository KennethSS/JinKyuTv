package com.jinkyu.tv.navigation

import androidx.navigation.NavController

internal fun NavController.navigateSplash() {
    navigate(Splash.route)
}

internal object Splash {
    const val route: String = "splash"
}