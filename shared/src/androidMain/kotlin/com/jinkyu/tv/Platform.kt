package com.jinkyu.tv

import androidx.media3.exoplayer.ExoPlayer
import com.jinkyu.tv.data.UserRepository
import com.jinkyu.tv.data.UserRepositoryImpl
import com.jinkyu.tv.data.VideoRepository
import com.jinkyu.tv.data.VideoRepositoryImpl
import com.jinkyu.tv.presentation.login.LoginViewModel
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.presentation.register.RegisterViewModel
import com.jinkyu.tv.presentation.player.PlayerViewModel
import com.jinkyu.tv.presentation.splash.AndroidSplashViewModel
import com.jinkyu.tv.presentation.register.AndroidRegisterViewModel
import com.jinkyu.tv.presentation.video.AndroidVideoViewModel
import com.jinkyu.tv.presentation.login.AndroidLoginViewModel
import com.jinkyu.tv.presentation.splash.SplashViewModel
import com.jinkyu.tv.presentation.videos.VideoViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual fun platformModule() = module {
    single<HttpClient> {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<VideoRepository> { VideoRepositoryImpl(get()) }
    factory { params ->
        SplashViewModel(params.get())
    }
    factory { param ->
        MainViewModel(null, get())
    }
    factory { param ->
        ExoPlayer.Builder(param.get())
    }
    factory { param ->
        PlayerViewModel(param.get())
    }
    factory { params ->
        RegisterViewModel(params.get(), params.get())
    }
    factory { params ->
        LoginViewModel(params.get(), params.get())
    }
    factory { params ->
        VideoViewModel(params.get(), params.get())
    }
    viewModelOf(::AndroidSplashViewModel)
    viewModelOf(::AndroidRegisterViewModel)
    viewModelOf(::AndroidLoginViewModel)
    viewModelOf(::AndroidVideoViewModel)
}
