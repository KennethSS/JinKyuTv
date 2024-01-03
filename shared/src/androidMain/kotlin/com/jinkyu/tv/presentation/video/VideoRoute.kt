package com.jinkyu.tv.presentation.video

import androidx.compose.runtime.Composable
import com.jinkyu.tv.presentation.videos.VideoScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun VideoRoute(
    navigatePlayer: (String) -> Unit,
    viewModel: AndroidVideoViewModel = koinViewModel()
) {
    VideoScreen(
        navigateVideo = navigatePlayer,
        viewModel = viewModel.viewModel
    )
}