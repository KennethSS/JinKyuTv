package com.jinkyu.tv.presentation.login

sealed class LoginNavigationAction {
    data object NavigateToMain : LoginNavigationAction()
    data object NavigateRegister : LoginNavigationAction()
}