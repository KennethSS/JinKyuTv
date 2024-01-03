package com.jinkyu.tv.data

import com.jinkyu.tv.domain.util.Result
import com.jinkyu.tv.presentation.videos.Video

interface VideoRepository {
    suspend fun videos(): Result<List<Video>>
}
