package com.jinkyu.tv.presentation.player

import platform.AVFoundation.AVPlayer
import platform.AVFoundation.pause
import platform.AVFoundation.play

actual class PlayerViewModel(
    val player: AVPlayer
): MediaPlayer {

    override fun pause() {
        player.pause()
    }

    override fun play() {
        player.play()
    }
}