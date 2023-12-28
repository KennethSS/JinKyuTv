package com.jinkyu.tv.presentation.splash

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashRoute(
    navigateMain: () -> Unit,
    navigateSign: () -> Unit,
    viewModel: AndroidSplashViewModel = koinViewModel()
) {
    SplashScreen(
        navigateMain = navigateMain,
        navigateSign = navigateSign,
        viewModel = viewModel.viewModel
    )
}