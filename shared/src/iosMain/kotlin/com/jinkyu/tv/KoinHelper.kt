package com.jinkyu.tv

import com.jinkyu.tv.presentation.login.LoginViewModel
import com.jinkyu.tv.presentation.player.PlayerViewModel
import com.jinkyu.tv.presentation.register.RegisterViewModel
import com.jinkyu.tv.presentation.videos.VideoViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinHelper : KoinComponent {
    private val playerViewModel: PlayerViewModel by inject()
    private val registerViewModel: RegisterViewModel by inject()
    private val loginViewModel: LoginViewModel by inject()
    private val videoViewModel: VideoViewModel by inject()

    fun playerViewModel(): PlayerViewModel = playerViewModel
    fun registerViewModel(): RegisterViewModel = registerViewModel
    fun loginViewModel(): LoginViewModel = loginViewModel
    fun videoViewModel(): VideoViewModel = videoViewModel
}