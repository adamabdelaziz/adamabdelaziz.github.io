package org.adam.resume.website.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

enum class WindowSizeClass {
    Compact,
    Medium,
    Expanded
}

@Composable
fun rememberWindowSizeClass(): WindowSizeClass {
    val viewportSize = rememberViewportSize()
    return when {
        viewportSize.width < 600.dp -> WindowSizeClass.Compact
        viewportSize.width < 840.dp -> WindowSizeClass.Medium
        else -> WindowSizeClass.Expanded
    }
}