package com.github.common.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacer(modifier: Modifier = Modifier, size: Int = 16) {
    Spacer(modifier = modifier.height(size.dp))
}

@Composable
fun HorizontalSpacer(modifier: Modifier = Modifier, size: Int = 16) {
    Spacer(modifier = modifier.width(size.dp))
}