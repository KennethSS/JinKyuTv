package com.jinkyu.tv.domain.util

sealed class Result<T>(val data: T?, val throwable: Throwable? = null) {
    class Success<T>(data: T): Result<T>(data = data)
    class Error<T>(throwable: Throwable): Result<T>(data = null, throwable = throwable)
}
