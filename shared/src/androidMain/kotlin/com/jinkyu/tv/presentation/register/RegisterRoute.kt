package com.jinkyu.tv.presentation.register

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterRoute(
    navigateVideoList: () -> Unit,
    navigateLogin: () -> Unit,
    viewModel: AndroidRegisterViewModel = koinViewModel()
) {
    RegisterScreen(
        navigateLogin = navigateLogin,
        navigateMain = navigateVideoList,
        viewModel = viewModel.viewModel
    )
}