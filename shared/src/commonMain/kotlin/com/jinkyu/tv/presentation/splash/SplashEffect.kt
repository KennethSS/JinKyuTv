package com.jinkyu.tv.presentation.splash

sealed interface SplashEffect {
    data object NavigateMain : SplashEffect
    data object NavigateSign : SplashEffect
}