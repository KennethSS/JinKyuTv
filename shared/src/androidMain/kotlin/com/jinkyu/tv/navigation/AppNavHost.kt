package com.jinkyu.tv.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jinkyu.tv.MainScreen
import com.jinkyu.tv.presentation.login.LoginRoute
import com.jinkyu.tv.presentation.register.RegisterRoute
import com.jinkyu.tv.presentation.splash.SplashRoute

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = Splash.route
) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(
            route = Splash.route
        ) {
            SplashRoute(
                navigateMain = { navController.navigateMain() },
                navigateLogin = { navController.navigateLogin() }
            )
        }
        composable(
            route = Login.route
        ) {
            LoginRoute(
                navigateMain = { navController.navigateMain() },
                navigateRegister = { navController.navigateRegister() }
            )
        }
        composable(
            route = Register.route
        ) {
            RegisterRoute(
                navigateLogin = { navController.navigateUp() },
                navigateMain = { navController.navigateMain() }
            )
        }
        composable(
            route = Main.route
        ) {
            MainScreen()
        }
    }
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInFromRight() =
    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutToRight() =
    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)