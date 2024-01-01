package com.jinkyu.tv.ui.system

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jinkyu.tv.ui.AppNameLabel
import com.jinkyu.tv.ui.Divider

@Composable
fun AppLogoLabel() {
    Text(
        modifier = Modifier.fillMaxWidth().padding(vertical = 42.dp),
        text = AppNameLabel,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun WelcomeLabel(
    firstLabel: String,
    secondLabel: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = firstLabel,
            fontSize = 25.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        Text(
            text = secondLabel,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            color = ColorGray,
        )
        Divider(height = 24)
    }
}

@Composable
fun Label(
    label: String
) {
    Text(
        modifier = Modifier.padding(vertical = 8.dp),
        text = label,
        fontSize = 14.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF00004D),
    )
}
