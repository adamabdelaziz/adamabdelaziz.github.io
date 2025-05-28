package org.adam.resume.website.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Menu
import kotlinx.coroutines.launch
import org.adam.resume.website.ABOUT_ME_LIST
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteEvent.OnToggleThemeClicked
import org.adam.resume.website.SiteState
import org.adam.resume.website.SiteTabs
import org.adam.resume.website.ui.components.HeaderRowPortrait
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentTypography

@Composable
fun PortraitLayoutNew(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = { },
                backgroundColor = CurrentColors.background,
                contentColor = CurrentColors.primary,
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(FeatherIcons.Menu, "Menu")
                    }
                },
                actions = {
                    HeaderRowPortrait(
                        modifier = Modifier.fillMaxWidth().background(CurrentColors.background),
                        isDarkTheme = state.isDarkTheme,
                        onToggleTheme = {
                            onEvent(
                                OnToggleThemeClicked
                            )
                        },
                        onAboutMeSection = state.selectedTab == SiteTabs.ABOUT,
                        iconSize = 32.dp,
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                elevation = 0.dp,
                backgroundColor = CurrentColors.background,
                contentColor = CurrentColors.primary,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    SiteTabs.entries.forEach { tab ->
                        BottomBarIconButton(
                            icon = tab.icon,
                            label = tab.title,
                            targetTab = tab,
                            onEvent = onEvent,
                            state = state
                        )
                    }
                }
            }
        },
        drawerContent = {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                ContactSection(
                    modifier = Modifier.fillMaxSize().background(color = CurrentColors.background),
                    state = state,
                    onEvent = onEvent,
                    fontSize = CurrentTypography.h1.fontSize,
                    subFontSize = CurrentTypography.caption.fontSize,
                )
            }

        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(CurrentColors.background)
            ) {
                ContentSectionPortrait(
                    state = state,
                    onEvent = onEvent,
                )
            }
        }
    )
}

@Composable
private fun BottomBarIconButton(
    icon: ImageVector,
    label: String,
    targetTab: SiteTabs,
    onEvent: (SiteEvent) -> Unit,
    state: SiteState
) {
    IconButton(
        onClick = { onEvent(SiteEvent.OnTabSelected(targetTab)) }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.padding(bottom = 8.dp),
                imageVector = icon,
                contentDescription = label,
                tint = if (state.selectedTab == targetTab) CurrentColors.primary else CurrentColors.onBackground
            )
            Text(
                textAlign = TextAlign.Center,
                text = label,
                style = CurrentTypography.button,
                color = if (state.selectedTab == targetTab) CurrentColors.primary else CurrentColors.onBackground
            )
        }
    }
}

@Composable
fun AboutSectionPortrait(
    modifier: Modifier = Modifier,
    state: SiteState,
    onEvent: (SiteEvent) -> Unit
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        //ContactSection(modifier = Modifier.weight(1f), state = state, onEvent = onEvent, fontSize = 32.sp, subFontSize = 24.sp)
        AnimatedAboutMeParagraph(modifier = Modifier.weight(1f), sentences = ABOUT_ME_LIST)
    }
}