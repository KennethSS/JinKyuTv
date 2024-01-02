package com.jinkyu.tv.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.compose.koinInject


@Composable
fun SplashScreen(
    navigateMain: () -> Unit,
    navigateLogin: () -> Unit,
    viewModel: SplashViewModel = koinInject(),
) {
    LaunchedEffect(true) {
        viewModel.effect.collect { effect ->
            when (effect) {
                SplashEffect.NavigateMain -> navigateMain()
                SplashEffect.NavigateLogin -> navigateLogin()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text("Splash")
    }

}