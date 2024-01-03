package com.jinkyu.tv.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

internal fun NavController.navigateVideo(
    popup: String = Splash.route
) {
    navigate(
        route = Video.route,
        navOptions = NavOptions.Builder()
            .setPopUpTo(popup, true)
            .build(),
    )
}

internal object Video {
    const val route: String = "video"
}
