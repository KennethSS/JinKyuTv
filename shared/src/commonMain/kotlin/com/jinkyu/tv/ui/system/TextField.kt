package com.jinkyu.tv.ui.system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jinkyu.tv.ui.Divider

@Composable
fun JinKyuTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    hint: String = "",
    hasSendButton: Boolean = false,
    onSendClicked: () -> Unit = {}
) {
    val hasLabel = label.isNotBlank()
    val hasHint = hint.isNotBlank()
    Column(
        modifier = modifier
    ) {
        Divider(height = 12)
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when {
                hasLabel -> {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = text,
                        onValueChange = onValueChange,
                        label = { Text(label) },
                    )
                }
                hasHint -> {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = text,
                        onValueChange = onValueChange,
                        placeholder = { Text(hint) },
                    )
                }
                hasLabel && hasHint -> {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = text,
                        onValueChange = onValueChange,
                        label = { Text(label) },
                    )
                }
                else -> {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = text,
                        onValueChange = onValueChange,
                        placeholder = { Text(label) },
                    )
                }
            }
            if (hasSendButton) {
                Divider(width = 12)
                Icon(
                    imageVector = Icons.Default.Send,
                    modifier = Modifier.size(24.dp).clickable { onSendClicked() },
                    contentDescription = ""
                )
            }
        }
    }
}
