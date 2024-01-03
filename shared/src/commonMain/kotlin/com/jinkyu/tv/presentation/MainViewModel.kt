package com.jinkyu.tv.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.jinkyu.tv.data.UserRepository
import com.jinkyu.tv.domain.chat.Chat
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.ChildEvent
import dev.gitlive.firebase.database.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.minus
import kotlin.time.Duration

class MainViewModel(
    private val coroutineScope: CoroutineScope?,
    private val userRepository: UserRepository
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Default)

    val chatList = mutableStateListOf<Chat>()

    val message = mutableStateOf("")
    private val db = Firebase.database
        .reference()
        .child(CHAT_CHILD_DATABASE)

    init {
        /*viewModelScope.launch {
            db.valueEvents
                .take(20)
                .collect {
                    val chat = it.value<Chat>()
                    chatList.add(chat)
                    this.coroutineContext.job.cancel()
                    observeMessage()
                }
        }*/
        observeMessage()
    }

    private fun observeMessage() {
        viewModelScope.launch {
            db.childEvents()
                .filter { it.type == ChildEvent.Type.ADDED }
                .map { it.snapshot.value<Chat>() }
                .filter {
                    val now = Clock.System.now()
                    val atLeastValidChatPeriod = now.minus(30, DateTimeUnit.SECOND).epochSeconds
                    it.date > atLeastValidChatPeriod
                }
                .collect { chat -> chatList.add(chat) }
        }
    }

    fun sendMessage() {
        val chat = Chat(
            nickname = userRepository.getUserNickName(),
            message = message.value,
            date = Clock.System.now().epochSeconds
        )

        viewModelScope.launch {
            Firebase.database
                .reference()
                .child(CHAT_CHILD_DATABASE)
                .push()
                .setValue(chat)
        }
        message.value = ""
    }

    fun onTyping(text: String) {
        message.value = text
    }

    companion object {
        const val CHAT_CHILD_DATABASE = "chat"
        val nicknames = listOf("Kenneth", "Kevin", "Michael", "Son")
        val messages = listOf("Hi~", "Awesome!", "Wow", "lololololol")
    }
}