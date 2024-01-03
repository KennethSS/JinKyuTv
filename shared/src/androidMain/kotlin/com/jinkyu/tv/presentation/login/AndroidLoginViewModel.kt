package com.jinkyu.tv.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinkyu.tv.data.UserRepository

class AndroidLoginViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    val viewModel by lazy {
        LoginViewModel(
            coroutineScope = viewModelScope,
            userRepository = userRepository
        )
    }
}