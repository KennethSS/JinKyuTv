package com.jinkyu.tv.data.model

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse<T>(
    val isSuccess: Boolean = false,
    val code: Int = 0,
    val message: String? = null,
    val result: T
)
