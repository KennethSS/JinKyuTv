package com.jinkyu.tv

import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.presentation.player.PlayerViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

actual fun platformModule() = module {
    factory { param ->
        MainViewModel()
    }
    /*factory { param ->
        ExoPlayer.Builder(androidContext())
            .build()
    }*/
    factoryOf(::PlayerViewModel)
}