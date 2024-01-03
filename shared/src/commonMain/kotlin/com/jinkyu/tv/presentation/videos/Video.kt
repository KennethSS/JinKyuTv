package com.jinkyu.tv.presentation.videos

import com.jinkyu.tv.data.model.response.GetVideosResponse

data class Video(
    val videoIdx: Int,
    val videoName: String,
    val videoUrl: String,
    val videoThumbnail: String
)

fun GetVideosResponse.toVideo(): Video {
    return Video(
        videoIdx = videoIdx,
        videoName = videoName,
        videoUrl = videoUrl,
        videoThumbnail = videoThumbnail
    )
}