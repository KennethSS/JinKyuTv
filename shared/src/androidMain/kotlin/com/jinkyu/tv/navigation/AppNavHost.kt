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
import com.jinkyu.tv.RegisterScreen
import com.jinkyu.tv.presentation.RegisterViewModel
import com.jinkyu.tv.presentation.splash.AndroidSplashViewModel
import com.jinkyu.tv.presentation.splash.SplashRoute
import com.jinkyu.tv.presentation.splash.SplashScreen

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
                navigateSign = { }
            )
        }
        composable(
            route = "login"
        ) {
            RegisterScreen(viewModel = RegisterViewModel())
        }
        composable(
            route = "register"
        ) {
            RegisterScreen(viewModel = RegisterViewModel())
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