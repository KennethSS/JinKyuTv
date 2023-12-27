package com.jinkyu.tv.ui.system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JinKyuTopBar(
    label: String,
    onBackButtonClicked: () -> Unit,
    hasOtherButton: Boolean = false,
    otherButtonIcons: ImageVector = Icons.Default.Close,
    onOtherButtonClicked: () -> Unit = {},
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "뒤로가기 버튼",
            modifier = Modifier.size(24.dp).clickable { onBackButtonClicked() }
        )
        Text(
            text = label,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        if (hasOtherButton) {
            Icon(
                imageVector = otherButtonIcons,
                contentDescription = "추가 버튼",
                modifier = Modifier.size(24.dp).clickable { onOtherButtonClicked() }
            )
        } else {
            Spacer(modifier = Modifier.size(24.dp))
        }

    }
}
