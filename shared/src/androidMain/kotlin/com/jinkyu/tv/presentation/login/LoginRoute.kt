package com.jinkyu.tv.presentation.login

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginRoute(
    navigateRegister: () -> Unit,
    navigateMain: () -> Unit,
    viewModel: AndroidLoginViewModel = koinViewModel()
) {
    LoginScreen(
        navigateRegister = navigateRegister,
        navigateMain = navigateMain,
        viewModel = viewModel.viewModel
    )
}