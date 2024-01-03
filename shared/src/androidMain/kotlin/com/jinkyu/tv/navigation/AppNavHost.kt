package com.jinkyu.tv.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jinkyu.tv.MainScreen
import com.jinkyu.tv.presentation.login.LoginRoute
import com.jinkyu.tv.presentation.register.RegisterRoute
import com.jinkyu.tv.presentation.splash.SplashRoute
import com.jinkyu.tv.presentation.video.VideoRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Video.route
) {


    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(
            route = Splash.route
        ) {
            SplashRoute(
                navigateMain = { navController.navigateVideo() },
                navigateLogin = { navController.navigateLogin() }
            )
        }
        composable(
            route = Login.route,
            enterTransition = { slideInFromRight() }
        ) {
            LoginRoute(
                navigateVideoList = { navController.navigateVideo(Login.route) },
                navigateRegister = { navController.navigateRegister() }
            )
        }
        composable(
            route = Register.route,
            enterTransition = { slideInFromRight() }
        ) {
            RegisterRoute(
                navigateLogin = { navController.navigateUp() },
                navigateVideoList = { navController.navigateVideo(Register.route) }
            )
        }
        composable(
            route = Video.route,
            enterTransition = { slideInFromRight() }
        ) {
            VideoRoute(
                navigatePlayer = { navController.navigatePlayer(it) }
            )
        }
        composable(
            route = "${Player.route}/{url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType }),
            enterTransition = { slideInFromRight() }
        ) { backStackEntry ->
            MainScreen(backStackEntry.arguments?.getString("url").orEmpty())
        }
    }
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInFromRight() =
    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutToRight() =
    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)