package com.jinkyu.tv.presentation.splash

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashRoute(
    navigateMain: () -> Unit,
    navigateLogin: () -> Unit,
    viewModel: AndroidSplashViewModel = koinViewModel()
) {
    SplashScreen(
        navigateMain = navigateMain,
        navigateLogin = navigateLogin,
        viewModel = viewModel.viewModel
    )
}