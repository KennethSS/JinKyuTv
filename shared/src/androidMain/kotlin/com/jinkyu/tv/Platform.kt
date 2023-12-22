package com.jinkyu.tv

import com.jinkyu.tv.presentation.MainViewModel
import org.koin.dsl.module

actual fun platformModule() = module {
    factory { param ->
        MainViewModel(
            coroutineScope = param.get()
        )
    }
}