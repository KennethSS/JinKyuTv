package com.jinkyu.tv.data

import com.jinkyu.tv.data.model.BaseResponse
import com.jinkyu.tv.data.model.response.GetVideosResponse
import com.jinkyu.tv.domain.util.Result
import com.jinkyu.tv.presentation.videos.Video
import com.jinkyu.tv.presentation.videos.toVideo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class VideoRepositoryImpl(
    private val httpClient: HttpClient
): VideoRepository {

    override suspend fun videos(): Result<List<Video>> {
        runCatching {
            httpClient.get {
                url(NetworkConstants.BASE_URL + "/videos")
                contentType(ContentType.Application.Json)
            }
        }.onSuccess {
            val result = it.body<BaseResponse<List<GetVideosResponse>>>()
            return when (result.isSuccess) {
                true -> Result.Success((result.result?.map { response -> response.toVideo() } ?: emptyList()))
                false -> Result.Error(Throwable(message = result.message))
            }
        }.onFailure {
            return Result.Error(it)
        }
        return Result.Error(Throwable("네트워크 연동에 실패했습니다."))
    }
}
