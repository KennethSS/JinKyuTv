package com.jinkyu.tv.data

import com.jinkyu.tv.data.model.response.PostLoginResponse
import com.jinkyu.tv.data.model.response.PostRegisterResponse
import com.jinkyu.tv.domain.util.Result

interface UserRepository {

    suspend fun register(
        nickName: String,
        email: String,
        password: String
    ): Result<PostRegisterResponse?>

    suspend fun login(
        email: String,
        password: String
    ): Result<PostLoginResponse?>
}
