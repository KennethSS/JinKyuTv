package com.jinkyu.tv.domain.chat


import dev.gitlive.firebase.database.ServerValue
import kotlinx.serialization.Serializable

@Serializable
data class Chat(
    val nickname: String,
    val message: String,
    val date: Long,
    val timestamp: ServerValue = ServerValue.TIMESTAMP
)