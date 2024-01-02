package com.jinkyu.tv.presentation.register

import com.jinkyu.tv.domain.user.UserInput
import com.jinkyu.tv.presentation.login.LoginNavigationAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val coroutineScope: CoroutineScope? = null
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _navigationAction: MutableSharedFlow<RegisterNavigationAction> = MutableSharedFlow<RegisterNavigationAction>()
    val navigationAction: SharedFlow<RegisterNavigationAction> = _navigationAction.asSharedFlow()

    private val _email: MutableStateFlow<String> = MutableStateFlow<String>("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _nickName: MutableStateFlow<String> = MutableStateFlow<String>("")
    val nickName: StateFlow<String> = _nickName.asStateFlow()

    private val _password: MutableStateFlow<String> = MutableStateFlow<String>("")
    val password: StateFlow<String> = _password.asStateFlow()

    val registerEnable: StateFlow<Boolean> = combine(_email, _nickName, _password) { email, nickName, password ->
        email.isNotBlank() && nickName.isNotBlank() && password.isNotBlank()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    private val _rememberMe: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    val rememberMe: StateFlow<Boolean> = _rememberMe.asStateFlow()

    fun onUserInput(type: UserInput, input: String) {
        when (type) {
            UserInput.NICKNAME -> _nickName.value = input
            UserInput.EMAIL -> _email.value = input
            UserInput.PASSWORD -> _password.value = input
        }
    }

    fun onSignUpClicked() {
        viewModelScope.launch {
            if (registerEnable.value) _navigationAction.emit(RegisterNavigationAction.NavigateToMain)
        }
    }

    fun onBackButtonClicked() {
        viewModelScope.launch {
            _navigationAction.emit(RegisterNavigationAction.NavigateLogin)
        }
    }

    fun onRememberMeClicked(enable: Boolean) {
        _rememberMe.value = enable
    }
}
