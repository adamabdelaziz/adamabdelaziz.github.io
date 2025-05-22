package org.adam.resume.website.ui.landscape

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.SiteTabs
import org.adam.resume.website.WORD_LIST
import org.adam.resume.website.ui.components.HeaderRowNew
import org.adam.resume.website.ui.components.OutlinedText
import org.adam.resume.website.ui.components.projectList
import org.adam.resume.website.ui.theme.AppTheme
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.DarkPastelAppColors
import org.adam.resume.website.ui.theme.LightPastelAppColors

@Composable
fun LandscapeLayoutNew(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    AppTheme(colors = if (state.isDarkTheme) DarkPastelAppColors else LightPastelAppColors) {
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
            .background(CurrentColors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedText(text = "Adam Abdelaziz", modifier = Modifier.padding(bottom = 64.dp))
        AnimatedContent(
            targetState = state.outlinedText,
            transitionSpec = {
                (scaleIn(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) togetherWith fadeOut())
                    .using(SizeTransform(clip = false))
            },
            label = "OutlinedTextTransition"
        ) {
            OutlinedText(text = it, fontSize = 48.sp)
        }
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
            .background(CurrentColors.background)
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

                SiteTabs.SKILLS_AND_TECHNOLOGIES -> {
                    SkillsAndTechnologiesSection(state, onEvent)
                }

                SiteTabs.PROJECTS -> {
                    ProjectsSection(state, onEvent)
                }
            }
        }
    }
}

@Composable
fun ProjectsSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Row(modifier = Modifier.fillMaxSize().background(CurrentColors.background)) {
        Column(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WordGrid(
                modifier = Modifier.fillMaxWidth().background(CurrentColors.surface, shape = RoundedCornerShape(24.dp)),
                state = state,
                onClick = { onEvent(SiteEvent.OnProjectClicked(it)) },
                wordList = projectList.map { it.title }
            )
        }
        /*
            Clicked Word will then show content here pertaining to it.
         */
        Column(
            modifier = Modifier.padding(vertical = 48.dp, horizontal = 24.dp).weight(1f).fillMaxHeight()
                .background(shape = RoundedCornerShape(48.dp), color = CurrentColors.error),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

        }
    }
}

@Composable
fun AboutSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Row(modifier = Modifier.fillMaxSize().background(CurrentColors.background)) {

    }
}

@Composable
fun SkillsAndTechnologiesSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Row(modifier = Modifier.fillMaxSize().background(CurrentColors.background)) {
        Column(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WordGrid(
                modifier = Modifier.fillMaxWidth().background(CurrentColors.surface, shape = RoundedCornerShape(24.dp)),
                state = state,
                onClick = { onEvent(SiteEvent.OnSkillClicked(it)) },
            )
        }
        /*
            Clicked Word will then show content here pertaining to it.
         */
        Column(
            modifier = Modifier.padding(vertical = 48.dp, horizontal = 24.dp).weight(1f).fillMaxHeight()
                .background(shape = RoundedCornerShape(48.dp), color = CurrentColors.error),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

        }
    }
}


@Composable
fun WordGrid(
    modifier: Modifier = Modifier,
    wordList: List<String> = WORD_LIST,
    state: SiteState,
    onClick: (String) -> Unit = {},
) {
    val cornerOptions = listOf(8.dp, 16.dp, 24.dp, 32.dp)
    val colors = CurrentColors.listColors

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 240.dp),
        contentPadding = PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier
    ) {
        items(wordList) { word ->
            val backgroundColor = remember(state.isDarkTheme) {
                colors.random()
            }
            val cornerRadius = remember { 16.dp }

            Box(
                modifier = Modifier
                    .clickable { onClick(word) }
                    .clip(RoundedCornerShape(cornerRadius))
                    .background(backgroundColor)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = word,
                    fontSize = 24.sp,
                    color = if (state.isDarkTheme) Color.White else Color.Black,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}