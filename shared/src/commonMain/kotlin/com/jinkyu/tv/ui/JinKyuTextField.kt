package com.jinkyu.tv.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JinKyuTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    Column(
        modifier = modifier
    ) {
        Divider(height = 12)
        TextField(
            modifier = modifier,
            value = text,
            onValueChange = onValueChange,
            label = { Text(label) }
        )
    }
}
