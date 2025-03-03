package com.github.common.component


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * A vertical spacer to add space between UI components.
 *
 * @param modifier Custom modifier for additional styling.
 * @param size The height of the spacer in DP (default is 16dp).
 */
@Composable
fun VerticalSpacer(
    modifier: Modifier = Modifier,
    size: Int = 16
) {
    Spacer(modifier = modifier.then(Modifier.height(size.dp)))
}

/**
 * A horizontal spacer to add space between UI components.
 *
 * @param modifier Custom modifier for additional styling.
 * @param size The width of the spacer in DP (default is 16dp).
 */
@Composable
fun HorizontalSpacer(
    modifier: Modifier = Modifier,
    size: Int = 16
) {
    Spacer(modifier = modifier.then(Modifier.width(size.dp)))
}

/**
 * Previews for both VerticalSpacer and HorizontalSpacer.
 */
@Preview(showBackground = true)
@Composable
fun PreviewSpacers() {
    VerticalSpacer()
    HorizontalSpacer()
}
