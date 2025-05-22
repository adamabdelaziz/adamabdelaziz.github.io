package org.adam.resume.website

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import kotlinx.browser.document
import org.adam.resume.website.ui.landscape.LandscapeLayoutNew
import org.adam.resume.website.ui.portrait.PortraitLayoutNew
import org.adam.resume.website.ui.rememberViewportSize

@Composable
fun App() {
    val viewportSize = rememberViewportSize()
    val scrollState = rememberScrollState()
    val viewModel: SiteViewModel = remember { SiteViewModel() }
    val state = viewModel.state.value

    LaunchedEffect(viewportSize) {
        viewModel.onEvent(SiteEvent.OnViewportSizeChanged(viewportSize))
    }

    val isPortrait = state.viewportSize.height > state.viewportSize.width

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

