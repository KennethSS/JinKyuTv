package com.jinkyu.tv.data.model.request

data class PostRegisterRequest(
    val nickName: String,
    val id: String,
    val email: String,
    val password: String
)
