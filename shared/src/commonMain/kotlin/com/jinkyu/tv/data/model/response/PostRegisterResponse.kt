package com.jinkyu.tv.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PostRegisterResponse(
    val jwt: String,
    val userIdx: Int
)
