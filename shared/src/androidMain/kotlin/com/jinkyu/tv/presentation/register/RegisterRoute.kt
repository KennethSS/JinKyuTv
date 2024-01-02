package com.jinkyu.tv.presentation.register

import androidx.compose.runtime.Composable
import com.jinkyu.tv.RegisterScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterRoute(
    navigateLogin: () -> Unit,
    viewModel: AndroidRegisterViewModel = koinViewModel()
) {
    RegisterScreen(
        navigateLogin = navigateLogin,
        viewModel = viewModel.viewModel
    )
}