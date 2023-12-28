package com.jinkyu.tv.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class AndroidSplashViewModel : ViewModel() {

    val viewModel by lazy {
        SplashViewModel(
            coroutineScope = viewModelScope
        )
    }
}