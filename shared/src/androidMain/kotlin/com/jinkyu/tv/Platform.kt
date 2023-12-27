package com.jinkyu.tv

import com.jinkyu.tv.presentation.LoginViewModel
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.presentation.RegisterViewModel
import org.koin.dsl.module

actual fun platformModule() = module {
    factory { param ->
        MainViewModel()
        RegisterViewModel()
        LoginViewModel()
    }
}
