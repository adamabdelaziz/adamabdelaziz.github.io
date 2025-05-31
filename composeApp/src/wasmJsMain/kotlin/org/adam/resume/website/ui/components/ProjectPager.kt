package org.adam.resume.website.ui.components

import androidx.compose.animation.Crossfade
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowLeft
import compose.icons.feathericons.ArrowRight
import compose.icons.feathericons.Github
import kotlinx.coroutines.launch
import org.adam.resume.website.openUrl
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentDimensions
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
                        0 -> ProjectView(
                            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp).background(CurrentColors.background),
                            project = projectList[0]
                        )

                        1 -> ProjectView(
                            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp).background(CurrentColors.background),
                            project = projectList[1]
                        )

                        2 -> ProjectView(
                            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp).background(CurrentColors.background),
                            project = projectList[2]
                        )
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
fun ProjectStack(modifier: Modifier = Modifier, height: Dp) {
    Column(modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Skills and Projects",
            color = CurrentColors.onSecondary,
            style = CurrentTypography.h1,
            modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp),
            textAlign = TextAlign.Center
        )
        projectList.forEachIndexed { index, project ->
            val isEven = index % 2 == 0
            Row(
                modifier = Modifier.fillMaxWidth().height(0.7f * height),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                if (isEven) Spacer(Modifier.weight(1f))

                ProjectView(
                    modifier = Modifier.weight(1f).fillMaxHeight(0.9f).padding(horizontal = 16.dp)
                        .background(CurrentColors.secondary, shape = RoundedCornerShape(48.dp)),
                    project = project
                )

                if (!isEven) Spacer(Modifier.weight(1f))
            }
        }
    }

}

@Composable
fun ProjectRow(
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        projectList.forEach {
            ProjectView(
                modifier = Modifier.weight(1f).fillMaxHeight(0.7f).padding(horizontal = 16.dp)
                    .background(CurrentColors.secondary, shape = RoundedCornerShape(48.dp)),
                project = it
            )
        }
    }
}

@Composable
fun ProjectColumn(modifier: Modifier = Modifier, height: Dp) {
    Column(modifier) {
        projectList.forEach {
            Column(
                modifier = modifier.padding(vertical = 48.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProjectView(
                    modifier = modifier.padding(horizontal = 24.dp)
                        .background(CurrentColors.secondary, shape = RoundedCornerShape(48.dp)),
                    project = it
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
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = project.title,
            color = CurrentColors.onSecondary,
            style = CurrentTypography.h1,
            modifier = Modifier.fillMaxWidth().padding(CurrentDimensions.spacingMedium),
            textAlign = TextAlign.Center
        )

        Text(
            text = project.blurb,
            color = CurrentColors.onSecondary,
            style = CurrentTypography.h2,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(horizontal = CurrentDimensions.spacingSmall)
        )

        Spacer(Modifier.height(CurrentDimensions.spacingMedium))

        project.points.forEach { point ->
            Text(
                text = "• $point",
                color = CurrentColors.onSecondary,
                style = CurrentTypography.h2,
                modifier = Modifier.fillMaxWidth().padding(horizontal = CurrentDimensions.spacingMedium, vertical = CurrentDimensions.spacingSmall)
            )
        }

        Spacer(Modifier.height(CurrentDimensions.spacingMedium))

        if (project.githubUrl != null) {
            HeaderIcon(
                modifier = Modifier.size(CurrentDimensions.minTouchTargetSize).padding(vertical = CurrentDimensions.spacingSmall),
                onClick = { openUrl(project.githubUrl) },
                imageVector = FeatherIcons.Github,
            )
        } else {
            Text(
                text = "Github link to come",
                color = CurrentColors.onSecondary,
                style = CurrentTypography.h3,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(vertical = CurrentDimensions.spacingSmall)
            )
        }
    }
}


const val PAGE_COUNT = 3

data class Project(
    val title: String,
    val blurb: String,
    val points: List<String>,
    val githubUrl: String? = null,
)

val kovidProject = Project(
    title = "Kovid",
    blurb = "Android app to track COVID-19 cases in your area.",
    points = listOf(
        "Used a now deprecated COVID-19 API to fetch data for the USA as well as each state",
        "MVVM architecture with LiveData and viewbinding with XML for UI",
        "Hilt for dependency injection and Jetpack Room for persistence"
    ),
    githubUrl = "https://github.com/adamabdelaziz/Kovid/tree/master"
)

val kryptoProject = Project(
    title = "Krypto",
    blurb = "Kotlin Multiplatform (Desktop) app to track Solana tokens as well as swap them based on inputted parameters.",
    points = listOf(
        "Uses the DexScreener API to fetch up to date crypto prices.",
        "Uses the Jupiter API to get quotes and swap Solana tokens",
        "MVI architecture with Kotlin Flow and Jetpack Compose for UI",
        "Ktor for network calls and Koin for dependency injection",
    ),
    githubUrl = "https://github.com/adamabdelaziz/Krypto"
)

val composeWeather = Project(
    title = "Compose Weather",
    blurb = "Android app to track the weather in your area.",
    points = listOf(
        "Uses the OpenWeather API to fetch up to date weather based on user location.",
        "MVVM architecture with LiveData and Jetpack Compose for UI",
        "Jetpack Room for persistence and DataStore for user settings",
        "Hilt for dependency injection and Retrofit for network calls"
    ),
    githubUrl = "https://github.com/adamabdelaziz/ComposeWeather/tree/main"
)

val kinetic = Project(
    title = "Kinetic",
    blurb = "Kotlin Multiplatform (Android & iOS) app to track workouts and monitor exercise progress.",
    points = listOf(
        "Shared UI and business logic across Android and iOS using Kotlin Multiplatform and Compose Multiplatform",
        "Built with a unidirectional MVI architecture, leveraging Kotlin Flow for reactive state management",
        "Backend powered by Ktor and GraphQL, enabling flexible and typed data access",
        "Koin used for dependency injection across shared and platform-specific modules",
    ),
)

val projectList = listOf(kinetic, kryptoProject, composeWeather, kovidProject, )