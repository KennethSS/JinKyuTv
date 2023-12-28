package com.jinkyu.tv.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

internal fun NavController.navigateMain() {
    navigate(
        route = Main.route,
        navOptions = NavOptions.Builder()
            .setPopUpTo(Splash.route, true)
            .build(),
    )
}

internal object Main {
    const val route: String = "main"
}