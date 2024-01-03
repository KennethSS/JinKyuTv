package com.jinkyu.tv.presentation.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinkyu.tv.data.VideoRepository
import com.jinkyu.tv.presentation.videos.VideoViewModel

class AndroidVideoViewModel(
    private val videoRepository: VideoRepository
) : ViewModel() {

    val viewModel by lazy {
        VideoViewModel(
            coroutineScope = viewModelScope,
            videoRepository = videoRepository
        )
    }
}