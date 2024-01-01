package com.jinkyu.tv.ui.system

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    hint: String = "",
    hasSendButton: Boolean = false,
    onSendClicked: () -> Unit = {}
) {
    BasicTextField(
        modifier = modifier
            .background(Color.White, MaterialTheme.shapes.small)
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(size = 5.dp))
            .background(Color.White, shape = RoundedCornerShape(size = 5.dp))
            .padding(12.dp),
        value = text,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = Color.Black,
            fontSize = 14.sp
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) {
                        Text(
                            hint,
                            style = LocalTextStyle.current.copy(
                                color = ColorGray,
                                fontSize = 14.sp
                            )
                        )
                    }
                    innerTextField()
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
    )
}

@Composable
fun JinKyuPasswordTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    BasicTextField(
        modifier = modifier
            .background(Color.White, MaterialTheme.shapes.small)
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(size = 5.dp))
            .background(Color.White, shape = RoundedCornerShape(size = 5.dp))
            .padding(12.dp),
        value = text,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = Color.Black,
            fontSize = 14.sp
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) {
                        Text(
                            hint,
                            style = LocalTextStyle.current.copy(
                                color = ColorGray,
                                fontSize = 14.sp
                            )
                        )
                    }
                    innerTextField()
                }
                Divider(width = 12)
                Icon(
                    imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    modifier = Modifier.size(18.dp).clickable { passwordVisible = !passwordVisible },
                    contentDescription = ""
                )
            }
        }
    )
}
