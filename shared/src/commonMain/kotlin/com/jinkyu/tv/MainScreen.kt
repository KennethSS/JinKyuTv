package com.jinkyu.tv

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.ui.ChatList
import org.koin.compose.koinInject

@Composable
fun MainScreen() {

    val mainViewModel = MainViewModel() //koinInject<MainViewModel>()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            VideoPlayer(
                modifier = Modifier,
                url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            )
            ChatList(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                items = mainViewModel.chatList
            )
        }
    }
}