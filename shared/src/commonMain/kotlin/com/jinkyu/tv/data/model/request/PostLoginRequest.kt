package com.jinkyu.tv.data.model.request

import kotlinx.serialization.Serializable

data class PostLoginRequest(
    @Serializable("id") val id: String,
    val password: String
)
