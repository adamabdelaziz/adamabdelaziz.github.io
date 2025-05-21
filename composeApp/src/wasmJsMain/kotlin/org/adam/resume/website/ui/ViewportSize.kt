package org.adam.resume.website.ui

import androidx.compose.runtime.*
import kotlinx.browser.window

@Composable
fun rememberViewportSize(): ViewportSize {
    var viewportSize by remember { mutableStateOf(ViewportSize(window.innerWidth, window.innerHeight)) }

    DisposableEffect(Unit) {
        val listener = { _: org.w3c.dom.events.Event ->
            viewportSize = ViewportSize(window.innerWidth, window.innerHeight)
        }

        window.addEventListener("resize", listener)

        onDispose {
            window.removeEventListener("resize", listener)
        }
    }

    return viewportSize
}


data class ViewportSize(val width: Int, val height: Int)
