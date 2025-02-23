package org.adam.resume.website

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Github
import compose.icons.feathericons.Linkedin
import compose.icons.feathericons.Mail
import compose.icons.feathericons.Paperclip
import org.adam.resume.website.ui.Side
import org.adam.resume.website.ui.ViewportSize
import org.adam.resume.website.ui.borderOnSides
import org.adam.resume.website.ui.components.BottomLanding
import org.adam.resume.website.ui.components.HeaderIcon
import org.adam.resume.website.ui.components.HeaderIconExtended
import org.adam.resume.website.ui.components.ProjectPager
import org.adam.resume.website.ui.components.RainingWordsAnimation
import org.adam.resume.website.ui.components.TextSection
import org.adam.resume.website.ui.components.ThemeSwitch
import org.adam.resume.website.ui.components.TopLanding
import org.adam.resume.website.ui.rememberViewportSize
import org.adam.resume.website.ui.theme.AppTheme
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.DarkColorsCute
import org.adam.resume.website.ui.theme.DarkWinterColors

@Composable
fun App() {
    var isDarkTheme by rememberSaveable { mutableStateOf(false) }

    val viewportSize = rememberViewportSize()
    val isPortrait = viewportSize.height > viewportSize.width

    val scrollState = rememberScrollState()

    val isAtTop = scrollState.value == 0
    val isAtBottom = scrollState.value  >= (scrollState.maxValue * .65)

    AppTheme(colors = if (isDarkTheme) DarkWinterColors else DarkColorsCute) {
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
fun HeaderRow(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = true,
    onToggleTheme: (Boolean) -> Unit = {},
    isAtBottom: Boolean,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ThemeSwitch(
            modifier = Modifier.background(CurrentColors.background),
            isDarkTheme = isDarkTheme,
            onToggleTheme = onToggleTheme
        )
        Spacer(Modifier.weight(1f))
        if (!isAtBottom) {
            HeaderIcon(
                onClick = { openUrl("google.com") },
                imageVector = FeatherIcons.Github,
            )
            HeaderIcon(
                onClick = { openUrl("google.com") },
                imageVector = FeatherIcons.Linkedin,
            )
            HeaderIcon(
                onClick = { openUrl("google.com") },
                imageVector = FeatherIcons.Mail,
            )
            HeaderIcon(
                onClick = { openUrl("google.com") },
                imageVector = FeatherIcons.Paperclip,
            )
        }
    }
}

@Composable
fun IconColumn(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        HeaderIconExtended(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { openUrl("google.com") },
            imageVector = FeatherIcons.Github,
            label = "Github"
        )
        HeaderIconExtended(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { openUrl("google.com") },
            imageVector = FeatherIcons.Linkedin,
            label = "LinkedIn"
        )
        HeaderIconExtended(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { openUrl("google.com") },
            imageVector = FeatherIcons.Mail,
            label = "E-Mail Me"
        )
        HeaderIconExtended(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { openUrl("google.com") },
            imageVector = FeatherIcons.Paperclip,
            label = "My Resume"
        )

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
                modifier = Modifier.fillMaxWidth().height(viewportSize.height.dp)
            )
        } else {
            LandscapeLayout(
                modifier = Modifier.fillMaxWidth().height(viewportSize.height.dp)
            )
        }

        BottomLanding(modifier = Modifier.height(viewportSize.height.dp))
    }
}

@Composable
fun PortraitLayout(modifier: Modifier = Modifier) {
}

@Composable
fun LandscapeLayout(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth().weight(1f).background(CurrentColors.background).borderOnSides(sides = setOf(Side.Bottom))) {
            TextSection(
                modifier = Modifier.fillMaxHeight().weight(1f).background(CurrentColors.background).borderOnSides(sides = setOf(Side.Right, Side.Bottom)),
                text = "Skills\nand\nTechnologies"
            )
            RainingWordsAnimation(modifier = Modifier.fillMaxHeight().weight(3f).clipToBounds(), WORD_LIST)
        }
        Row(modifier = Modifier.fillMaxWidth().weight(1f).background(CurrentColors.background)) {
            ProjectPager(modifier = Modifier.fillMaxHeight().weight(3f))
            TextSection(
                modifier = Modifier.fillMaxHeight().weight(1f).background(CurrentColors.background).borderOnSides(setOf(Side.Left)),
                text = "Personal\nProjects"
            )
        }
    }
}