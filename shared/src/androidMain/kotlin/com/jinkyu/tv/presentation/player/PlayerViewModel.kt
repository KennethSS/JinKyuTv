package com.jinkyu.tv.presentation.player

import androidx.media3.common.MediaItem
import androidx.media3.common.Player

actual class PlayerViewModel(
    private val url: String = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
): MediaPlayer {

    var player: Player? = null

    fun prepareAndPlay() {
        val mediaItem = MediaItem.fromUri(url)
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    override fun pause() {
        player?.pause()
    }

    override fun play() {
        player?.play()
    }
}