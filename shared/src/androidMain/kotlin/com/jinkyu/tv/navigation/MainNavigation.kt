package com.jinkyu.tv.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

internal fun NavController.navigateMain(
    popup: String = Splash.route
) {
    navigate(
        route = Main.route,
        navOptions = NavOptions.Builder()
            .setPopUpTo(popup, true)
            .build(),
    )
}

internal object Main {
    const val route: String = "main"
}
