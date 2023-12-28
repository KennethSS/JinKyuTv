package com.jinkyu.tv.ui.system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    label = {
                        Text(
                            text = label,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF9E9E9E),
                        )
                    },
                )
            }
            hasHint -> {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = text,
                    onValueChange = onValueChange,
                    placeholder = {
                        Text(
                            text = hint,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF9E9E9E),
                        )
                    },
                )
            }
            hasLabel && hasHint -> {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = text,
                    onValueChange = onValueChange,
                    label = {
                        Text(
                            text = label,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF9E9E9E),
                        )
                    },
                )
            }
            else -> {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = text,
                    onValueChange = onValueChange,
                    placeholder = {
                        Text(
                            text = label,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF9E9E9E),
                        )
                    },
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

@Composable
fun JinKyuPasswordTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = onValueChange,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = {
            Text(
                text = hint,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF9E9E9E),
            )
        },
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            Icon(
                imageVector = image,
                modifier = Modifier.size(24.dp).clickable { passwordVisible = !passwordVisible },
                contentDescription = ""
            )
        }
    )
}
