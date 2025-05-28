package org.adam.resume.website.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import kotlinx.browser.window

@Composable
fun rememberViewportSize(): DpSize {
    val density = LocalDensity.current

    var viewportSize by remember {
        mutableStateOf(
            with(density) {
                DpSize(window.innerWidth.toDp(), window.innerHeight.toDp())
            }
        )
    }

    DisposableEffect(density) {
        val listener = { _: org.w3c.dom.events.Event ->
            viewportSize = with(density) {
                DpSize(window.innerWidth.toDp(), window.innerHeight.toDp())
            }
        }

        window.addEventListener("resize", listener)

        onDispose {
            window.removeEventListener("resize", listener)
        }
    }

    return viewportSize
}