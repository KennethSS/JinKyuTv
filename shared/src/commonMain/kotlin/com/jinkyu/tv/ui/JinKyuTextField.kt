package com.jinkyu.tv.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
        Spacer(modifier = modifier.height(12.dp))
        TextField(
            modifier = modifier,
            value = text,
            onValueChange = onValueChange,
            label = { Text(label) }
        )
    }
}
