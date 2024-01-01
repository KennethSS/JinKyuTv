package com.jinkyu.tv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SocialLoginDivider() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f).height(1.dp).background(Color.Black))
        Divider(width = 18)
        Text(
            text = OrWithLabel,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Divider(width = 18)
        Spacer(modifier = Modifier.weight(1f).height(1.dp).background(Color.Black))
    }
}

@Composable
fun SocialLoginButtons(
    onGitHubButtonClicked: () -> Unit,
    onGitLabButtonClicked: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(size = 5.dp))
                .background(Color.White, shape = RoundedCornerShape(size = 5.dp))
                .clickable { onGitHubButtonClicked() }
                .padding(vertical = 12.dp),
            text = GitHubLabel,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Divider(width = 12)
        Text(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(size = 5.dp))
                .background(Color.White, shape = RoundedCornerShape(size = 5.dp))
                .clickable { onGitLabButtonClicked() }
                .padding(vertical = 12.dp),
            text = GitLabLabel,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}
