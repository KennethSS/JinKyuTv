package com.jinkyu.tv.domain.user

import com.jinkyu.tv.data.UserClient
import com.jinkyu.tv.data.model.response.PostRegisterResponse
import com.jinkyu.tv.domain.util.Resource

class RegisterUseCase(
    private val client: UserClient
) {
    suspend fun invoke(
        nickName: String,
        id: String,
        email: String,
        password: String
    ): Resource<PostRegisterResponse> {
        return try {
            val result = client.register(nickName, id, email, password)
            Resource.Success(result)
        } catch (exception: Exception) {
            exception.printStackTrace()
            Resource.Error(exception)
        }
    }
}
