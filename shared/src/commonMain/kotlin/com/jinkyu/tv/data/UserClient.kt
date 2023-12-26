package com.jinkyu.tv.data

import com.jinkyu.tv.data.model.response.PostLoginResponse
import com.jinkyu.tv.data.model.response.PostRegisterResponse
import com.jinkyu.tv.domain.util.Resource


interface UserClient {
    suspend fun register(
        nickName: String,
        id: String,
        email: String,
        password: String
    ): Resource<PostRegisterResponse>

    suspend fun login(
        id: String,
        password: String
    ): Resource<PostLoginResponse>
}
