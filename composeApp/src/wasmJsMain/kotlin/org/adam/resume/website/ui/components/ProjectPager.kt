package org.adam.resume.website.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowLeft
import compose.icons.feathericons.ArrowRight
import kotlinx.coroutines.launch
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentTypography

@Composable
fun ProjectPager(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { PAGE_COUNT })
    val scope = rememberCoroutineScope()

    Column(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {

                HeaderIcon(
                    modifier = Modifier.alpha(if (pagerState.currentPage == 0) 0f else 1f).size(48.dp).padding(end = 8.dp),
                    imageVector = FeatherIcons.ArrowLeft,
                    onClick = {
                        if (pagerState.currentPage > 0) {
                            scope.launch {
                                pagerState.scrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    },
                )

                Crossfade(modifier = Modifier.weight(1f).padding(end = 8.dp), targetState = page, label = "PageCrossfade") { currentPage ->
                    when (currentPage) {
                        0 -> ProjectView(modifier = Modifier.fillMaxSize().background(CurrentColors.background), project = projectList[0])
                        1 -> ProjectView(modifier = Modifier.fillMaxSize().background(CurrentColors.background), project = projectList[1])
                        2 -> ProjectView(modifier = Modifier.fillMaxSize().background(CurrentColors.background), project = projectList[2])
                    }
                }

                HeaderIcon(
                    modifier = Modifier.alpha(if (pagerState.currentPage != (PAGE_COUNT - 1)) 1f else 0f).size(48.dp).padding(end = 8.dp),
                    imageVector = FeatherIcons.ArrowRight,
                    onClick = {
                        if (pagerState.currentPage < PAGE_COUNT) {
                            scope.launch {
                                pagerState.scrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    },
                )

            }
        }
    }
}

@Composable
fun ProjectView(
    modifier: Modifier = Modifier,
    project: Project,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Text(
            text = project.title,
            style = CurrentTypography.h2,
            color = CurrentColors.onBackground,
            modifier = Modifier.padding(8.dp)
        )

        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = project.blurb,
                    color = CurrentColors.onSurface,
                    style = CurrentTypography.h2
                )
            }

            Spacer(Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .background(CurrentColors.secondary, shape = RoundedCornerShape(16.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                project.points.forEach { point ->
                    Text(
                        text = "• $point",
                        color = CurrentColors.onSecondary,
                        style = CurrentTypography.h2,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)
                    )
                }

            }
        }
    }
}

const val PAGE_COUNT = 3

data class Project(
    val title: String,
    val blurb: String,
    val points: List<String>
)

val kovidProject = Project(
    title = "Kovid",
    blurb = "A simple app to track COVID-19 cases in your area.",
    points = listOf(
        "Uses the COVID-19 API to fetch data.",
        "Displays data in a user-friendly format.",
        "Allows users to search for their area."
    )
)

val kryptoProject = Project(
    title = "Krypto",
    blurb = "A simple app to track your crypto portfolio.",
    points = listOf(
        "Uses the CoinGecko API to fetch data.",
        "Displays data in a user-friendly format.",
        "Allows users to search for their coins."
    )
)

val composeWeather = Project(
    title = "Compose Weather",
    blurb = "A simple app to track the weather in your area.",
    points = listOf(
        "Uses the OpenWeather API to fetch data.",
        "Displays data in a user-friendly format.",
        "Allows users to search for their area."
    )
)

val projectList = listOf(kryptoProject, composeWeather, kovidProject)