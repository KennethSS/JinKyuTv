package com.jinkyu.tv.data.model

open class BaseResponse<T>(
    val isSuccess: Boolean = false,
    val code: Int = 0,
    val message: String? = null,
    val result: T
)
