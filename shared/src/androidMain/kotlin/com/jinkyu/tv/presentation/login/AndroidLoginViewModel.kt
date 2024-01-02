package com.jinkyu.tv.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinkyu.tv.presentation.LoginViewModel
import com.jinkyu.tv.presentation.RegisterViewModel

class AndroidLoginViewModel : ViewModel() {

    val viewModel by lazy {
        LoginViewModel(
            coroutineScope = viewModelScope
        )
    }
}