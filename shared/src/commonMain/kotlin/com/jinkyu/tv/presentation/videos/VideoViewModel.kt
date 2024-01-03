package com.jinkyu.tv.presentation.videos

import com.jinkyu.tv.data.VideoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VideoViewModel(
    private val coroutineScope: CoroutineScope? = null,
    private val videoRepository: VideoRepository
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _videos: MutableStateFlow<List<Video>> = MutableStateFlow<List<Video>>(emptyList())
    val videos: StateFlow<List<Video>> = _videos.asStateFlow()

    init {
        viewModelScope.launch {
            val result = videoRepository.videos()
            result.data?.let {
                _videos.value = it
            }
        }
    }
}
