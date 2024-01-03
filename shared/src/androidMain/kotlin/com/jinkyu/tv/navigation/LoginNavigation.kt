package com.jinkyu.tv.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

internal fun NavController.navigateLogin() {
    navigate(
        route = Login.route,
        navOptions = NavOptions.Builder()
            .setPopUpTo(Splash.route, true)
            .build(),
    )
}

internal object Login {
    const val route: String = "login"
}