package com.jinkyu.tv.data

import com.jinkyu.tv.data.model.response.PostLoginResponse
import com.jinkyu.tv.data.model.response.PostRegisterResponse
import com.jinkyu.tv.domain.util.Resource

interface UserClient {
    suspend fun register(
        nickName: String,
        email: String,
        password: String
    ): Resource<PostRegisterResponse>

    suspend fun login(
        email: String,
        password: String
    ): Resource<PostLoginResponse>
}
