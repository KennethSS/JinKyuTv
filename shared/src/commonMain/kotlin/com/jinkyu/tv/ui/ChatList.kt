package com.jinkyu.tv.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jinkyu.tv.domain.chat.Chat

@Composable
fun ChatList(
    modifier: Modifier = Modifier,
    items: List<Chat>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items) { chat ->
            ChatMessage(chat)
        }
    }
}

@Composable
fun ChatMessage(
    chat: Chat
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 3.dp)
    ) {
        Text(
            text = chat.nickname,
            color = Color(0xFF808080)
        )
        Text(
            text = chat.message,
            modifier = Modifier
                .padding(start = 4.dp),
            color = Color(0xFF000000)
        )
    }
}