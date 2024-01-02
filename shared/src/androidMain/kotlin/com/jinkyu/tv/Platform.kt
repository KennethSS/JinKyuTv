package com.jinkyu.tv

import androidx.media3.exoplayer.ExoPlayer
import com.jinkyu.tv.data.UserRepository
import com.jinkyu.tv.data.UserRepositoryImpl
import com.jinkyu.tv.presentation.login.LoginViewModel
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.presentation.register.RegisterViewModel
import com.jinkyu.tv.presentation.player.PlayerViewModel
import com.jinkyu.tv.presentation.splash.AndroidSplashViewModel
import com.jinkyu.tv.presentation.register.AndroidRegisterViewModel
import com.jinkyu.tv.presentation.login.AndroidLoginViewModel
import com.jinkyu.tv.presentation.splash.SplashViewModel
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
    factory { params ->
        RegisterViewModel(params.get())
    }
    factory { params ->
        LoginViewModel(params.get(), params.get())
    }
    viewModelOf(::AndroidSplashViewModel)
    viewModelOf(::AndroidRegisterViewModel)
    viewModelOf(::AndroidLoginViewModel)
}
