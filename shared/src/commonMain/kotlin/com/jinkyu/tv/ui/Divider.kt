package com.jinkyu.tv.ui

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.Divider(height: Int) {
    Spacer(modifier = Modifier.fillMaxWidth().height(height.dp))
}

@Composable
fun RowScope.Divider(width: Int) {
    Spacer(modifier = Modifier.width(width.dp))
}

@Composable
fun ColumnScope.SpacerWeight() {
    Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
}
