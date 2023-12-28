package com.jinkyu.tv

import androidx.compose.ui.window.ComposeUIViewController
import com.jinkyu.tv.presentation.splash.SplashScreen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import platform.UIKit.UIViewController

fun SplashViewController(
    navigateMain: () -> Unit,
    navigateSign: () -> Unit
): UIViewController {
    return ComposeUIViewController {
        SplashScreen(
            navigateMain = navigateMain,
            navigateSign = navigateSign,
        )
    }
}

fun MainViewController(): UIViewController {
    return ComposeUIViewController {
        MainScreen()
    }
}

suspend fun asyncFunctionExample() = coroutineScope {
    delay(1000L)
}