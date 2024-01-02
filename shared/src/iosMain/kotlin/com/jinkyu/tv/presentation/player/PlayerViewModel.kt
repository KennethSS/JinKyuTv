package com.jinkyu.tv.presentation.player

import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.Foundation.NSURL

actual class PlayerViewModel(
    val url: String = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
    val player: AVPlayer = AVPlayer(uRL = NSURL.URLWithString(url)!!)
): MediaPlayer {

    override fun pause() {
        player.pause()
    }

    override fun play() {
        player.play()
    }
}