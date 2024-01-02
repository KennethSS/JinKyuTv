package com.jinkyu.tv.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class AndroidLoginViewModel : ViewModel() {

    val viewModel by lazy {
        LoginViewModel(
            coroutineScope = viewModelScope
        )
    }
}