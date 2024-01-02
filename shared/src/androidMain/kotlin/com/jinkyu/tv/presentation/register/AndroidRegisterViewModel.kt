package com.jinkyu.tv.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinkyu.tv.data.UserRepository

class AndroidRegisterViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    val viewModel by lazy {
        RegisterViewModel(
            coroutineScope = viewModelScope,
            userRepository = userRepository
        )
    }
}