package org.adam.resume.website

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import org.adam.resume.website.ui.ViewportSize
import org.adam.resume.website.ui.components.BottomLanding
import org.adam.resume.website.ui.components.HeaderRow
import org.adam.resume.website.ui.components.ProjectColumn
import org.adam.resume.website.ui.components.ProjectRow
import org.adam.resume.website.ui.components.ProjectStack
import org.adam.resume.website.ui.components.RainingWordsAnimation
import org.adam.resume.website.ui.components.TopLanding
import org.adam.resume.website.ui.components.projectList
import org.adam.resume.website.ui.rememberViewportSize
import org.adam.resume.website.ui.theme.AppTheme
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.DarkColorsBlue
import org.adam.resume.website.ui.theme.LightColorsBlue

@Composable
fun App() {
    var isDarkTheme by rememberSaveable { mutableStateOf(false) }

    val viewportSize = rememberViewportSize()
    val isPortrait = viewportSize.height > viewportSize.width

    val scrollState = rememberScrollState()

    val isAtTop = scrollState.value == 0
    val isAtBottom = scrollState.value >= (scrollState.maxValue * .65)

    AppTheme(colors = if (isDarkTheme) DarkColorsBlue else LightColorsBlue) {
        Column(modifier = Modifier.fillMaxSize().background(CurrentColors.background)) {
            HeaderRow(
                isAtBottom = isAtBottom,
                modifier = Modifier.fillMaxWidth().background(CurrentColors.background).padding(16.dp),
                isDarkTheme = isDarkTheme,
                onToggleTheme = { isDarkTheme = it },
            )
            PageLayout(scrollState = scrollState, viewportSize = viewportSize, isPortrait = isPortrait)
        }
    }
}

@Composable
fun PageLayout(
    scrollState: ScrollState,
    viewportSize: ViewportSize,
    isPortrait: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(CurrentColors.background)
    ) {
        TopLanding(modifier = Modifier.height(viewportSize.height.dp))

        if (isPortrait) {
            PortraitLayout(
                modifier = Modifier.fillMaxWidth(),
                height = viewportSize.height.dp,
            )
        } else {
            LandscapeLayoutNew(
                modifier = Modifier.fillMaxWidth(),
                height = viewportSize.height.dp,
            )
        }

        BottomLanding(modifier = Modifier.height(viewportSize.height.dp), isPortrait = isPortrait)
    }
}

@Composable
fun PortraitLayout(modifier: Modifier = Modifier, height: Dp) {
    Box(modifier) {
        RainingWordsAnimation(modifier = Modifier.fillMaxWidth().height(height.times(1.2f)).clipToBounds(), WORD_LIST)
        ProjectColumn(modifier = modifier, height = height)
    }
}

@Composable
fun LandscapeLayout(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        RainingWordsAnimation(modifier = Modifier.fillMaxSize().clipToBounds(), WORD_LIST)
        ProjectRow(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun LandscapeLayoutNew(modifier: Modifier = Modifier, height: Dp) {
    Box(modifier = modifier) {
        RainingWordsAnimation(modifier = Modifier.fillMaxWidth().height(projectList.size * (height * 0.8f)).clipToBounds(), WORD_LIST)
        ProjectStack(modifier = Modifier.fillMaxSize(), height = height)
    }
}