package com.jinkyu.tv

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
actual fun VideoPlayer(modifier: Modifier, url: String) {

    AndroidView(
        factory = { context ->
            PlayerView(context).also {
                it.player = ExoPlayer.Builder(context)
                    .build()

                it.player?.let { player ->
                    val mediaItem = MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
                    player.setMediaItem(mediaItem)
                    player.prepare()
                    player.play()
                }
            }
                /*.apply {
                    setVideoPath(url)
                    val mediaController = MediaController(context)
                    mediaController.setAnchorView(this)
                    setMediaController(mediaController)
                    start()
                }*/
        },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f),
        update = {}
    )
}