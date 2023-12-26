package com.jinkyu.tv.domain.user

import com.jinkyu.tv.data.UserClient
import com.jinkyu.tv.data.model.response.PostLoginResponse
import com.jinkyu.tv.domain.util.Resource

class LoginUseCase(
    private val client: UserClient
) {
    suspend fun invoke(
        id: String,
        password: String
    ): Resource<PostLoginResponse> {
        return client.login(id, password)
    }
}
