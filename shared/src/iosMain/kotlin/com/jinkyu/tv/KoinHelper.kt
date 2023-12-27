package com.jinkyu.tv

import com.jinkyu.tv.presentation.player.PlayerViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinHelper : KoinComponent {
    private val playerViewModel: PlayerViewModel by inject()
    fun playerViewModel():PlayerViewModel = playerViewModel
}