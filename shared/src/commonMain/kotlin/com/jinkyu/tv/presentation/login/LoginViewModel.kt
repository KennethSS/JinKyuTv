package com.jinkyu.tv.presentation.login

import com.jinkyu.tv.data.UserRepository
import com.jinkyu.tv.domain.user.UserInput
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

class LoginViewModel(
    private val coroutineScope: CoroutineScope? = null,
    private val userRepository: UserRepository
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _navigationAction: MutableSharedFlow<LoginNavigationAction> = MutableSharedFlow<LoginNavigationAction>()
    val navigationAction: SharedFlow<LoginNavigationAction> = _navigationAction.asSharedFlow()

    private val _error: MutableStateFlow<String> = MutableStateFlow<String>("Login")
    val error: StateFlow<String> = _error.asStateFlow()

    private val _email: MutableStateFlow<String> = MutableStateFlow<String>("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password: MutableStateFlow<String> = MutableStateFlow<String>("")
    val password: StateFlow<String> = _password.asStateFlow()

    val loginEnable: StateFlow<Boolean> = combine(_email, _password) { email, password ->
        email.isNotBlank() && password.isNotBlank()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    private val _rememberMe: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    val rememberMe: StateFlow<Boolean> = _rememberMe.asStateFlow()

    fun onUserInput(type: UserInput, input: String) {
        when (type) {
            UserInput.EMAIL -> _email.value = input
            UserInput.PASSWORD -> _password.value = input
            else -> {}
        }
        _error.value = "Login"
    }

    fun onSignUpClicked() {
        viewModelScope.launch {
            _navigationAction.emit(LoginNavigationAction.NavigateRegister)
        }
    }

    fun onLoginClicked() {
        viewModelScope.launch {
            if (loginEnable.value) {
                val result = userRepository.login(email = email.value, password = password.value)
                result.data?.let {
                    _navigationAction.emit(LoginNavigationAction.NavigateToMain)
                }
                result.throwable?.let {
                    _error.emit(it.message ?: "")
                }
            }
        }
    }

    fun onRememberMeClicked(enable: Boolean) {
        _rememberMe.value = enable
    }
}
