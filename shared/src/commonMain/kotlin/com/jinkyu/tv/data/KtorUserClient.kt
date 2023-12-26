package com.jinkyu.tv.data

import com.jinkyu.tv.data.model.BaseResponse
import com.jinkyu.tv.data.model.request.PostRegisterRequest
import com.jinkyu.tv.data.model.response.PostRegisterResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorUserClient(
    private val httpClient: HttpClient
): UserClient {

    override suspend fun register(
        nickName: String,
        id: String,
        email: String,
        password: String
    ): PostRegisterResponse {
        val request = PostRegisterRequest(nickName, id, email, password)
        val result = try {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/app/users")
                contentType(ContentType.Application.Json)
                setBody(body = request)
            }
        } catch (exception: Exception) {
            throw exception
        }

        return result.body<BaseResponse<PostRegisterResponse>>().result
    }
}
