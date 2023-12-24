package com.jinkyu.tv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JinKyuButton(
    buttonLabel: String,
    enable: Boolean,
    onClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .wrapContentSize()
            .clip(shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .background(if (enable) Color.Blue else Color.LightGray)
                .clip(shape = RoundedCornerShape(12.dp))
                .clickable { onClicked() }
                .padding(vertical = 12.dp, horizontal = 24.dp),
            text = buttonLabel,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = if (enable) Color.White else Color.Black
        )
    }
}
