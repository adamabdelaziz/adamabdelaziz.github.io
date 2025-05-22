package org.adam.resume.website

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.adam.resume.website.ui.landscape.LandscapeLayoutNew
import org.adam.resume.website.ui.portrait.PortraitLayoutNew
import org.adam.resume.website.ui.rememberViewportSize

@Composable
fun App() {
    val viewportSize = rememberViewportSize()
    val isPortrait = viewportSize.height > viewportSize.width
    val scrollState = rememberScrollState()
    val viewModel: SiteViewModel = remember { SiteViewModel() }

    if (isPortrait) {
        PortraitLayoutNew(
            state = viewModel.state.value,
            onEvent = viewModel::onEvent,
        )
    } else {
        LandscapeLayoutNew(
            state = viewModel.state.value,
            onEvent = viewModel::onEvent,
        )
    }
}

