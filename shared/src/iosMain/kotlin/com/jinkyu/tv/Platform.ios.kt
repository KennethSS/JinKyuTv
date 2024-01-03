package com.jinkyu.tv

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import com.jinkyu.tv.data.UserRepository
import com.jinkyu.tv.data.UserRepositoryImpl
import com.jinkyu.tv.data.VideoRepository
import com.jinkyu.tv.data.VideoRepositoryImpl
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.presentation.login.LoginViewModel
import com.jinkyu.tv.presentation.player.PlayerViewModel
import com.jinkyu.tv.presentation.register.RegisterViewModel
import com.jinkyu.tv.presentation.splash.SplashViewModel
import com.jinkyu.tv.presentation.videos.VideoViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.dsl.module
import platform.AVFoundation.AVPlayerLayer
import platform.AVFoundation.play
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView


actual fun platformModule() = module {
    single<HttpClient> {
        HttpClient(Darwin) {
            install(ContentNegotiation) {
                json()
            }
        }

    }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<VideoRepository> { VideoRepositoryImpl(get()) }
    factory {
        MainViewModel(null, get())
    }

    factory {
        SplashViewModel(null)
    }
    factory {
        PlayerViewModel()
    }
    factory {
        RegisterViewModel(null, get())
    }
    factory {
        LoginViewModel(null, get())
    }
    factory {
        VideoViewModel(null, get())
    }
}

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun VideoPlayer(
    modifier: Modifier,
    playerViewModel: PlayerViewModel
) {

    val avPlayerViewController = remember { AVPlayerViewController() }
    val playerLayer = remember { AVPlayerLayer() }

    avPlayerViewController.player = playerViewModel.player
    avPlayerViewController.showsPlaybackControls = false
    avPlayerViewController.allowsPictureInPicturePlayback = true

    playerLayer.player = playerViewModel.player

    // Use a UIKitView to integrate with your existing UIKit views
    UIKitView(
        factory = {
            // Create a UIView to hold the AVPlayerLayer
            UIView().apply {
                addSubview(avPlayerViewController.view)
            }
        },
        onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            view.layer.setFrame(rect)
            playerLayer.setFrame(rect)
            avPlayerViewController.view.layer.frame = rect
            CATransaction.commit()
        },
        update = { view ->
            avPlayerViewController.player!!.play()
        },
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f)
    )
}