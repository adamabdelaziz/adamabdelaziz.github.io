package org.adam.resume.website

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import org.adam.resume.website.ui.WindowSizeClass
import org.adam.resume.website.ui.content.LandscapeLayoutNew
import org.adam.resume.website.ui.content.PortraitLayoutNew
import org.adam.resume.website.ui.rememberViewportSize
import org.adam.resume.website.ui.rememberWindowSizeClass
import org.adam.resume.website.ui.theme.AppTheme
import org.adam.resume.website.ui.theme.CompactDimensions
import org.adam.resume.website.ui.theme.CompactTypography
import org.adam.resume.website.ui.theme.DarkPastelAppColors
import org.adam.resume.website.ui.theme.ExpandedDimensions
import org.adam.resume.website.ui.theme.ExpandedTypography
import org.adam.resume.website.ui.theme.LightPastelAppColors
import org.adam.resume.website.ui.theme.MediumDimensions
import org.adam.resume.website.ui.theme.MediumTypography

@Composable
fun App() {
    val viewportSize = rememberViewportSize()
    val viewModel: SiteViewModel = remember { SiteViewModel() }

    val isPortrait = viewportSize.height > viewportSize.width
    val state by viewModel.state.collectAsState()

    val windowSizeClass = rememberWindowSizeClass()

    val siteTypography = when (windowSizeClass) {
        WindowSizeClass.Compact -> CompactTypography
        WindowSizeClass.Medium -> MediumTypography
        WindowSizeClass.Expanded -> ExpandedTypography
    }

    val siteDimensions = when (windowSizeClass) {
        WindowSizeClass.Compact -> CompactDimensions
        WindowSizeClass.Medium -> MediumDimensions
        WindowSizeClass.Expanded -> ExpandedDimensions
    }

    println("Window size class is ${windowSizeClass.name}")

    AppTheme(colors = if (state.isDarkTheme) DarkPastelAppColors else LightPastelAppColors, typography = siteTypography, dimensions = siteDimensions) {
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
}

