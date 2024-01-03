package com.jinkyu.tv.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

internal fun NavController.navigatePlayer(
    url: String,
) {
    val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
    navigate(
        route = "${Player.route}/$encodedUrl",
        navOptions = NavOptions.Builder()
            .build(),
    )
}

object Player {
    const val route: String = "player"
}
