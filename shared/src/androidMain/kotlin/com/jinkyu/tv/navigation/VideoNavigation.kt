package com.jinkyu.tv.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

internal fun NavController.navigateVideo() {
    navigate(
        route = Video.route,
        navOptions = NavOptions.Builder()
            .setPopUpTo(Login.route, true)
            .setPopUpTo(Register.route, true)
            .build(),
    )
}

internal object Video {
    const val route: String = "video"
}
