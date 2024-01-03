package com.jinkyu.tv.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetVideosResponse(
    val videoIdx: Int,
    val videoName: String,
    val videoUrl: String,
    val videoThumbnail: String
)
