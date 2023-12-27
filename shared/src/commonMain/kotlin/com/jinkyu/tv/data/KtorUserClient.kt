package com.jinkyu.tv.data

import com.jinkyu.tv.data.model.BaseResponse
import com.jinkyu.tv.data.model.request.PostLoginRequest
import com.jinkyu.tv.data.model.request.PostRegisterRequest
import com.jinkyu.tv.data.model.response.PostLoginResponse
import com.jinkyu.tv.data.model.response.PostRegisterResponse
import com.jinkyu.tv.domain.util.Resource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorUserClient(
    private val httpClient: HttpClient
): UserClient {

    override suspend fun register(
        nickName: String,
        email: String,
        password: String
    ): Resource<PostRegisterResponse> {
        val request = PostRegisterRequest(nickName = nickName, id = email, email = email, password = password)
        runCatching {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/users")
                contentType(ContentType.Application.Json)
                setBody(body = request)
            }
        }.onSuccess {
            val result = it.body<BaseResponse<PostRegisterResponse>>()
            return when (result.isSuccess) {
                true -> Resource.Success(result.result)
                false -> Resource.Error(Throwable(message = result.message))
            }
        }.onFailure {
            return Resource.Error(it)
        }
        return Resource.Error(Throwable("네트워크 연동에 실패했습니다."))
    }

    override suspend fun login(
        email: String,
        password: String
    ): Resource<PostLoginResponse> {
        val request = PostLoginRequest(id = email, password = password)
        runCatching {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/users/logIn")
                contentType(ContentType.Application.Json)
                setBody(body = request)
            }
        }.onSuccess {
            val result = it.body<BaseResponse<PostLoginResponse>>()
            return when (result.isSuccess) {
                true -> Resource.Success(result.result)
                false -> Resource.Error(Throwable(message = result.message))
            }
        }.onFailure {
            return Resource.Error(it)
        }
        return Resource.Error(Throwable("네트워크 연동에 실패했습니다."))
    }
}
