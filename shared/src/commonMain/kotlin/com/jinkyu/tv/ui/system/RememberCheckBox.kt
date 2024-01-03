package com.jinkyu.tv.ui.system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jinkyu.tv.ui.Divider
import com.jinkyu.tv.ui.DividerWeight
import com.jinkyu.tv.ui.ForgotPasswordLabel
import com.jinkyu.tv.ui.RememberMeLabel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RememberCheckBox(
    rememberMe: Boolean,
    onCheckBoxClicked: (Boolean) -> Unit,
    onForgotPasswordClicked: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { onCheckBoxClicked(it) },
                colors = CheckboxDefaults.colors(checkedColor = ColorBlue)
            )
        }
        Divider(width = 8)
        Text(
            text = RememberMeLabel,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF000C14),
        )
        DividerWeight()
        Text(
            modifier = Modifier.clickable { onForgotPasswordClicked() },
            text = ForgotPasswordLabel,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            color = ColorRed,
        )
    }
}
