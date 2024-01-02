package com.jinkyu.tv

import android.content.Context
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.jinkyu.tv.presentation.player.PlayerViewModel

@Composable
actual fun VideoPlayer(
    modifier: Modifier,
    playerViewModel: PlayerViewModel
) {

    var lifecycle by remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            lifecycle = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    AndroidView(
        factory = { context ->
            val player = getPlayer(context)
            val playerView = makePlayerView(context)

            playerViewModel.player = player
            playerViewModel.prepareAndPlay()

            playerView.also {
                it.player = player
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f),
        update = {
            when (lifecycle) {
                Lifecycle.Event.ON_PAUSE -> {
                    playerViewModel.pause()
                }
                Lifecycle.Event.ON_RESUME -> {
                    playerViewModel.play()
                    //it.onResume()
                    //it.player?.play()
                }
                else -> Unit
            }
        }
    )
}

private fun makePlayerView(context: Context): PlayerView {
    return PlayerView(context).apply {
        useController = false
    }
}

private fun getPlayer(context: Context): Player {
    return ExoPlayer.Builder(context)
        .build()
}