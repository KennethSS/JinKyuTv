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

internal fun NavController.navigateSignUp() {
    navigate(
        route = SignUp.route,
        navOptions = NavOptions.Builder()
            .setPopUpTo(Splash.route, true)
            .build(),
    )
}

internal fun NavController.navigateLogin() {
    navigate(
        route = Login.route,
        navOptions = NavOptions.Builder()
            .setPopUpTo(Splash.route, true)
            .build(),
    )
}

internal fun NavController.navigateRegister() {
    navigate(
        route = Login.route,
        navOptions = NavOptions.Builder()
            .build(),
    )
}

internal object Main {
    const val route: String = "main"
}

internal object SignUp {
    const val route: String = "signup"
}

internal object Login {
    const val route: String = "login"
}