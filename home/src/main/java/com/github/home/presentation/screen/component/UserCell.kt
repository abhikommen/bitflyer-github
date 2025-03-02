package com.github.home.presentation.screen.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.github.common.component.HorizontalSpacer
import com.github.home.domain.model.User

@Composable
fun UserCell(user: User, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = user.avatarUrl,
            contentDescription = "avatar",
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape)
        )
        HorizontalSpacer()

    }
}