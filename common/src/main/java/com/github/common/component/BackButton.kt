package com.github.common.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.github.common.R

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    size: Int = 30,
    tint: Color = MaterialTheme.colorScheme.onBackground,
    onBackClicked: () -> Unit = {}
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_back_button),
        contentDescription = "Back",
        tint = tint,
        modifier = modifier
            .size(size.dp)
            .clip(shape = CircleShape)
            .clickable(onClick = onBackClicked)
    )
}
