package com.jinkyu.tv.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.jinkyu.tv.domain.chat.Chat
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.ChildEvent
import dev.gitlive.firebase.database.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

class MainViewModel(
    private val coroutineScope: CoroutineScope?
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
                .collect { childEvent ->
                    if (childEvent.type == ChildEvent.Type.ADDED) {
                        val chat = childEvent.snapshot.value<Chat>()
                        chatList.add(chat)
                    }
                }
        }

    }

    fun sendMessage() {
        val chat = Chat(
            nickname = "kenneth",
            message = message.value
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