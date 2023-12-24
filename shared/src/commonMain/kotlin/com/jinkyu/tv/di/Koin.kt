package com.jinkyu.tv.di

import com.jinkyu.tv.platformModule
import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(
        commonModule()
    )
}

fun commonModule() = platformModule()