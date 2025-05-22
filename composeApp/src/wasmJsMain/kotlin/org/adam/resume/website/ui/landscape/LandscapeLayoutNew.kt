package org.adam.resume.website.ui.landscape

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.SiteTabs
import org.adam.resume.website.ui.components.HeaderRowNew
import org.adam.resume.website.ui.theme.AppTheme
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.DarkColorsBlue
import org.adam.resume.website.ui.theme.FrozenRed
import org.adam.resume.website.ui.theme.LightColorsBlue
import org.adam.resume.website.ui.theme.PineGreen

@Composable
fun LandscapeLayoutNew(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    AppTheme(colors = if (state.isDarkTheme) DarkColorsBlue else LightColorsBlue) {
        Column(modifier = Modifier.fillMaxSize().background(CurrentColors.background)) {
            HeaderRowNew(
                modifier = Modifier.fillMaxWidth().background(CurrentColors.background).padding(16.dp),
                state = state,
                onEvent = onEvent
            )
            Row(modifier = Modifier.fillMaxSize().background(CurrentColors.background)) {
                Column(modifier = Modifier.weight(1f).fillMaxHeight()) {
                    ContactSection(state, onEvent)
                }
                Column(modifier = Modifier.weight(2f).fillMaxHeight()) {
                    ContentSection(state, onEvent)
                }
            }
        }
    }
}

@Composable
fun ContactSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CurrentColors.onPrimary)
    ) {

    }
}

@Composable
fun ContentSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CurrentColors.error)
    ) {
        AnimatedContent(
            modifier = Modifier.fillMaxSize(),
            targetState = state.selectedTab,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            },
            label = "FadeScreenTransition"
        ) { tab ->
            when (tab) {
                SiteTabs.ABOUT -> {
                    AboutSection(state, onEvent)
                }

                SiteTabs.SKILLS_AND_PROJECTS -> {
                    SkillsAndProjectsSection(state, onEvent)

                }
            }
        }
    }
}


@Composable
fun AboutSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Row(modifier = Modifier.fillMaxSize().background(FrozenRed)) {

    }
}

@Composable
fun SkillsAndProjectsSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Row(modifier = Modifier.fillMaxSize().background(PineGreen)) {

    }
}
