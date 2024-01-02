package com.jinkyu.tv.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostLoginRequest(
    val id: String,
    val password: String
)
