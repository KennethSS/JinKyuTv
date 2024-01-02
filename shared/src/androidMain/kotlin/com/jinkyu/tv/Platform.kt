package com.jinkyu.tv

import androidx.media3.exoplayer.ExoPlayer
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.presentation.player.PlayerViewModel
import com.jinkyu.tv.presentation.splash.AndroidSplashViewModel
import com.jinkyu.tv.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual fun platformModule() = module {

    factory { params ->
        SplashViewModel(params.get())
    }
    factory { param ->
        MainViewModel()
    }
    factory { param ->
        ExoPlayer.Builder(param.get())
    }
    factory { param ->
        PlayerViewModel()
    }
    viewModelOf(::AndroidSplashViewModel)
}
