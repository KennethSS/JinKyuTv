package com.jinkyu.tv

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.presentation.player.PlayerViewModel
import com.jinkyu.tv.presentation.splash.SplashViewModel
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerLayer
import platform.AVFoundation.play
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.Foundation.NSURL
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView


actual fun platformModule() = module {
    factory {
        MainViewModel()
    }

    factory {
        SplashViewModel(null)
    }

    factoryOf(::PlayerViewModel)
}

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun VideoPlayer(modifier: Modifier, url: String) {
    val player = remember { AVPlayer(uRL = NSURL.URLWithString(url)!!) }
    val playerLayer = remember { AVPlayerLayer() }
    val avPlayerViewController = remember { AVPlayerViewController() }
    avPlayerViewController.player = player
    avPlayerViewController.showsPlaybackControls = true
    avPlayerViewController.allowsPictureInPicturePlayback = true

    playerLayer.player = player

    // Use a UIKitView to integrate with your existing UIKit views
    UIKitView(
        factory = {
            // Create a UIView to hold the AVPlayerLayer
            val playerContainer = UIView()
            playerContainer.addSubview(avPlayerViewController.view)
            // Return the playerContainer as the root UIView
            playerContainer
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
            player.play()
            avPlayerViewController.player!!.play()
        },
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f)
    )
}