package org.adam.resume.website.ui.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.adam.resume.website.ABOUT_ME_LIST
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentTypography

@Composable
fun AboutSection(
    modifier: Modifier = Modifier,
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    key(state.selectedTab) {
        Box(modifier = modifier.padding(end = 64.dp)) {
            AnimatedAboutMeParagraph(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                sentences = ABOUT_ME_LIST,
            )
        }
    }
}


@Composable
fun AnimatedAboutMeParagraph(
    modifier: Modifier = Modifier,
    sentences: List<String> = ABOUT_ME_LIST,
    delayBetween: Long = 1000L,
) {
    val visibleStates = remember { mutableStateListOf<Boolean>() }

    LaunchedEffect(Unit) {
        visibleStates.clear()
        if (visibleStates.size < sentences.size) {
            repeat(sentences.size) { visibleStates.add(false) }
        }

        sentences.indices.forEach { index ->
            delay(delayBetween)
            visibleStates[index] = true
        }
    }

    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        sentences.forEachIndexed { index, sentence ->
            val alignment = if (index % 2 == 0) Alignment.CenterStart else Alignment.CenterEnd
            val color = if (index % 2 == 0) CurrentColors.surface else CurrentColors.success

            AnimatedVisibility(
                visible = visibleStates.getOrNull(index) == true,
                enter = slideInVertically(
                    initialOffsetY = { it / 2 },
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) + fadeIn(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) + scaleIn(
                    initialScale = 0.8f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ),
                exit = fadeOut(animationSpec = spring(stiffness = Spring.StiffnessMedium))
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = alignment
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .padding(vertical = 16.dp)
                            .clip(RoundedCornerShape(24.dp)),
                        color = color
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = sentence,
                            style = CurrentTypography.h2,
                            color = CurrentColors.onSurface,
                        )
                    }
                }
            }
        }
    }
}
