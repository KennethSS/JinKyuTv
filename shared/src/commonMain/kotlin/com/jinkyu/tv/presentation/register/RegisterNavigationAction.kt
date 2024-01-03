package com.jinkyu.tv.presentation.register

sealed class RegisterNavigationAction {
    data object NavigateToMain : RegisterNavigationAction()
    data object NavigateLogin : RegisterNavigationAction()
}