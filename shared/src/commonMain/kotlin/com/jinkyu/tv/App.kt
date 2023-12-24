package com.jinkyu.tv

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jinkyu.tv.di.commonModule
import org.koin.compose.KoinApplication

@Composable
fun App(platform: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
//        MainScreen()
        RegisterScreen(modifier = Modifier.fillMaxSize())
//        LoginScreen(modifier = Modifier.fillMaxSize())
    }
}
