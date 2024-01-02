package com.jinkyu.tv

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.presentation.player.PlayerViewModel
import com.jinkyu.tv.ui.ChatList
import com.jinkyu.tv.ui.icon.Forward10
import com.jinkyu.tv.ui.icon.PlayCircle
import com.jinkyu.tv.ui.icon.Replay10
import org.koin.compose.koinInject

@Composable
fun MainScreen(
    playerViewModel: PlayerViewModel = koinInject()
) {
    val mainViewModel = MainViewModel()

    var visibleController by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
            ) {
                VideoPlayer(
                    modifier = Modifier,
                    playerViewModel = playerViewModel
                )
                if (visibleController) {
                    VideoController(
                        onClickBackground = { visibleController = false }
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16 / 9f)
                            .clickable { visibleController = true }
                    )
                }
            }
            ChatList(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                items = mainViewModel.chatList
            )
        }
    }
}

@Composable
private fun VideoController(
    onClickBackground: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f)
            .clickable { onClickBackground() }
            .background(Color(0xFF80000000)),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Image(
                Replay10,
                null,
                Modifier.size(36.dp)
            )
            Image(PlayCircle, null, Modifier.size(36.dp))
            Image(Forward10, null, Modifier.size(36.dp))
        }
    }
}