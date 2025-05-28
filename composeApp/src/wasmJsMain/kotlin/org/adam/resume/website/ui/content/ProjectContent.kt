package org.adam.resume.website.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.WORD_LIST
import org.adam.resume.website.thenIf
import org.adam.resume.website.ui.components.BouncyAnimatedSurfaceContent
import org.adam.resume.website.ui.components.ProjectView
import org.adam.resume.website.ui.components.projectList
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentDimensions
import org.adam.resume.website.ui.theme.CurrentTypography

@Composable
fun ProjectsSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Row(modifier = Modifier.fillMaxSize().background(CurrentColors.background), verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WordGrid(
                modifier = Modifier.fillMaxWidth(0.75f).background(CurrentColors.surface, shape = RoundedCornerShape(24.dp)),
                state = state,
                onClick = { onEvent(SiteEvent.OnProjectClicked(it)) },
                wordList = projectList.map { it.title },
                clickedWord = state.clickedProject?.title,
                columns = GridCells.Fixed(1)
            )
        }

        BouncyAnimatedSurfaceContent(
            modifier = Modifier.padding(vertical = CurrentDimensions.spacingLarge, horizontal = CurrentDimensions.spacingSmall).weight(1f).fillMaxWidth(),
            targetState = state.clickedProject,
        ) {
            it?.let {
                ProjectView(modifier = Modifier.fillMaxWidth(), project = it)
            }
        }
    }
}

@Composable
fun WordGrid(
    modifier: Modifier = Modifier,
    wordList: List<String> = WORD_LIST,
    state: SiteState,
    onClick: (String) -> Unit = {},
    clickedWord: String? = null,
    columns: GridCells = GridCells.Adaptive(minSize = 240.dp)
) {
    val colors = CurrentColors.listColors

    LazyVerticalGrid(
        columns = columns,
        contentPadding = PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier
    ) {
        items(wordList) { word ->
            val backgroundColor = remember(state.isDarkTheme) {
                colors.random()
            }
            val clicked = word == clickedWord

            Box(
                modifier = Modifier
                    .clickable { onClick(word) }
                    .thenIf(clicked, Modifier.border(2.dp, CurrentColors.secondary, RoundedCornerShape(24.dp)))
                    .clip(RoundedCornerShape(if (clicked) 24.dp else 16.dp))
                    .background(backgroundColor)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    style = CurrentTypography.h2,
                    text = word,
                    color = CurrentColors.onBackground,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}