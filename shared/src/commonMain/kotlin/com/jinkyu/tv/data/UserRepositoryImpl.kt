package com.jinkyu.tv.data

import com.jinkyu.tv.data.model.BaseResponse
import com.jinkyu.tv.data.model.request.PostLoginRequest
import com.jinkyu.tv.data.model.request.PostRegisterRequest
import com.jinkyu.tv.data.model.response.PostLoginResponse
import com.jinkyu.tv.data.model.response.PostRegisterResponse
import com.jinkyu.tv.domain.util.Result
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class UserRepositoryImpl(
    private val httpClient: HttpClient
): UserRepository {

    override suspend fun register(
        nickName: String,
        email: String,
        password: String
    ): Result<PostRegisterResponse?> {
        val request = PostRegisterRequest(userName = nickName, id = email, email = email, password = password)
        runCatching {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/users")
                contentType(ContentType.Application.Json)
                setBody(body = request)
            }
        }.onSuccess {
            val result = it.body<BaseResponse<PostRegisterResponse>>()
            return when (result.isSuccess) {
                true -> Result.Success(result.result)
                false -> Result.Error(Throwable(message = result.message))
            }
        }.onFailure {
            return Result.Error(it)
        }
        return Result.Error(Throwable("네트워크 연동에 실패했습니다."))
    }

    override suspend fun login(
        email: String,
        password: String
    ): Result<PostLoginResponse?> {
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
                true -> Result.Success(result.result)
                false -> Result.Error(Throwable(message = "아이디 또는 비밀번호를 확인해주세요."))
            }
        }.onFailure {
            return Result.Error(it)
        }
        return Result.Error(Throwable("네트워크 연결에 실패했습니다."))
    }
}
