package com.jinkyu.tv.presentation

import androidx.compose.runtime.mutableStateListOf
import com.jinkyu.tv.domain.chat.Chat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel(
    //private val coroutineScope: CoroutineScope?
) {

    //private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    val chatList = mutableStateListOf<Chat>()

    init {
        chatList.add(Chat(nicknames.random(), messages.random()))

        /*coroutineScope?.launch {
            repeat(10) {
                delay(1000L)
                val chatMessageCount = Random(3)
                    .nextInt()
                repeat(3) {
                    val chat = Chat(nicknames.random(), messages.random())
                    chatList.add(chat)
                }
            }
        }*/
    }


    companion object {
        val nicknames = listOf("Kenneth", "Kevin", "Michael", "Son")
        val messages = listOf("Hi~", "Awesome!", "Wow", "lololololol")
    }
}