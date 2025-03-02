package com.github.common.utility.extenstion

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

/**
 * Extension functions to generate colors with specific alpha values for transparency.
 */
fun Color.ninety() = copy(alpha = 0.9f)
fun Color.eighty() = copy(alpha = 0.8f)
fun Color.seventy() = copy(alpha = 0.7f)
fun Color.sixty() = copy(alpha = 0.6f)
fun Color.fifty() = copy(alpha = 0.5f)
fun Color.forty() = copy(alpha = 0.4f)
fun Color.thirty() = copy(alpha = 0.3f)
fun Color.twenty() = copy(alpha = 0.2f)
fun Color.ten() = copy(alpha = 0.1f)
fun Color.five() = copy(alpha = 0.05f)
fun Color.zero() = copy(alpha = 0.0f)

/**
 * Generates a color with the given alpha value.
 * @param alpha The alpha transparency value, ranging from 0.0 (completely transparent) to 1.0 (completely opaque).
 */
fun Color.alpha(alpha: Float) = copy(alpha = alpha)

/**
 * Brightens the color by increasing its lightness.
 * @param amount The amount to brighten the color, ranging from 0.0 (no change) to 1.0 (maximum brightness).
 * @return A new color with increased brightness.
 */
fun Color.brighten(amount: Float): Color {
    val hsv = FloatArray(3)
    android.graphics.Color.colorToHSV(toArgb(), hsv)

    // Increase lightness (value component in HSV) and constrain within [0, 1].
    hsv[2] = (hsv[2] + amount).coerceIn(0f, 1f)

    return Color(android.graphics.Color.HSVToColor(hsv))
}

/**
 * Darkens the color by decreasing its lightness.
 * @param amount The amount to darken the color, ranging from 0.0 (no change) to 1.0 (maximum darkness).
 * @return A new color with decreased brightness.
 */
fun Color.darken(amount: Float): Color {
    val hsv = FloatArray(3)
    android.graphics.Color.colorToHSV(toArgb(), hsv)

    // Decrease lightness (value component in HSV) and constrain within [0, 1].
    hsv[2] = (hsv[2] - amount).coerceIn(0f, 1f)

    return Color(android.graphics.Color.HSVToColor(hsv))
}
