package com.jinkyu.tv.data

import com.jinkyu.tv.data.model.response.PostRegisterResponse


interface UserClient {
    suspend fun register(
        nickName: String,
        id: String,
        email: String,
        password: String
    ): PostRegisterResponse
}
