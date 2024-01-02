package com.jinkyu.tv

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jinkyu.tv.presentation.player.PlayerViewModel

@Composable
expect fun VideoPlayer(
    modifier: Modifier,
    playerViewModel: PlayerViewModel
)