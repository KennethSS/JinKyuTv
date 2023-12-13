package com.jinkyu.tv

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}


@Composable
fun SampleText() {
    Text(text = "Hello Jin!")
}