package com.jinkyu.tv

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jinkyu.tv.di.commonModule
import com.jinkyu.tv.presentation.LoginViewModel
import com.jinkyu.tv.presentation.RegisterViewModel
import org.koin.compose.KoinApplication

@Composable
fun App(platform: String) {

    val registerViewModel = RegisterViewModel() //koinInject<MainViewModel>()
    val loginViewModel = LoginViewModel()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
//        MainScreen()
//        RegisterScreen(modifier = Modifier.fillMaxSize(), viewModel = registerViewModel)
        LoginScreen(modifier = Modifier.fillMaxSize(), viewModel = loginViewModel)
    }
}
