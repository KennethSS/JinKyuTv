package com.jinkyu.tv.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostRegisterRequest(
    val userName: String,
    val id: String,
    val email: String,
    val password: String
)
