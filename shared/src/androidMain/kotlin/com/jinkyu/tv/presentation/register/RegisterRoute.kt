package com.jinkyu.tv.presentation.register

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterRoute(
    navigateMain: () -> Unit,
    navigateLogin: () -> Unit,
    viewModel: AndroidRegisterViewModel = koinViewModel()
) {
    RegisterScreen(
        navigateLogin = navigateLogin,
        navigateMain = navigateMain,
        viewModel = viewModel.viewModel
    )
}