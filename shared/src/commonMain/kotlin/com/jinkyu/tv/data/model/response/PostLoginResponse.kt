package com.jinkyu.tv.data.model.response

data class PostLoginResponse(
    val jwt: String,
    val userIdx: Int
)
