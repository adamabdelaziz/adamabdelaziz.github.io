package org.adam.resume.website.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.window

@Composable
fun rememberViewportSize(): ViewportSize {
    var viewportSize by remember { mutableStateOf(ViewportSize(window.innerWidth, window.innerHeight)) }

    LaunchedEffect(Unit) {
        window.addEventListener("resize", {
            viewportSize = ViewportSize(window.innerWidth, window.innerHeight)
        })
    }

    return viewportSize
}

data class ViewportSize(val width: Int, val height: Int)
