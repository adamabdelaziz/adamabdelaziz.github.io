package org.adam.resume.website

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.adam.resume.website.ui.landscape.LandscapeLayoutNew
import org.adam.resume.website.ui.portrait.PortraitLayoutNew
import org.adam.resume.website.ui.rememberViewportSize

@Composable
fun App() {
    val viewportSize = rememberViewportSize()
    val viewModel: SiteViewModel = remember { SiteViewModel() }

    val isPortrait = viewportSize.height > viewportSize.width
    val state = viewModel.state.value

    if (isPortrait) {
        PortraitLayoutNew(
            state = state,
            onEvent = viewModel::onEvent,
        )
    } else {
        LandscapeLayoutNew(
            state = state,
            onEvent = viewModel::onEvent,
        )
    }
}

