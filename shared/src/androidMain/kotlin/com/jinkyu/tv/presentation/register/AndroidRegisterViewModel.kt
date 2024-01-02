package com.jinkyu.tv.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class AndroidRegisterViewModel : ViewModel() {

    val viewModel by lazy {
        RegisterViewModel(
            coroutineScope = viewModelScope
        )
    }
}