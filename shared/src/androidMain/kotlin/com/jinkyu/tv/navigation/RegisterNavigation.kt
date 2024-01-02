package com.jinkyu.tv.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

internal fun NavController.navigateRegister() {
    navigate(
        route = Register.route,
        navOptions = NavOptions.Builder()
            .setPopUpTo(Register.route, true)
            .build(),
    )
}

internal object Register {
    const val route: String = "register"
}
