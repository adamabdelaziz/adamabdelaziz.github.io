package org.adam.resume.website

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Github
import compose.icons.feathericons.Linkedin
import compose.icons.feathericons.Mail
import compose.icons.feathericons.Paperclip
import org.adam.resume.website.ui.Side
import org.adam.resume.website.ui.ViewportSize
import org.adam.resume.website.ui.borderOnSides
import org.adam.resume.website.ui.components.HeaderIcon
import org.adam.resume.website.ui.components.OutlinedText
import org.adam.resume.website.ui.components.ProjectPager
import org.adam.resume.website.ui.components.RainingWordsAnimation
import org.adam.resume.website.ui.components.TextSection
import org.adam.resume.website.ui.components.ThemeSwitch
import org.adam.resume.website.ui.rememberViewportSize
import org.adam.resume.website.ui.theme.AppTheme
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.DarkColorsCute
import org.adam.resume.website.ui.theme.DarkWinterColors
import org.jetbrains.compose.resources.painterResource
import resumewebsite2025.composeapp.generated.resources.Res
import resumewebsite2025.composeapp.generated.resources.backgroundImage10
import resumewebsite2025.composeapp.generated.resources.backgroundImage15

@Composable
fun App() {
    var isDarkTheme by rememberSaveable { mutableStateOf(false) }

    val viewportSize = rememberViewportSize()
    val isPortrait = viewportSize.height > viewportSize.width

    AppTheme(colors = if (isDarkTheme) DarkWinterColors else DarkColorsCute) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderRow(
                isDarkTheme = isDarkTheme,
                onToggleTheme = { isDarkTheme = it },
            )
            PageLayout(viewportSize = viewportSize, isPortrait = isPortrait)
        }
    }
}

@Composable
fun HeaderRow(isDarkTheme: Boolean = true, onToggleTheme: (Boolean) -> Unit = {}) {
    Row(
        modifier = Modifier.fillMaxWidth().background(CurrentColors.background).padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ThemeSwitch(
            modifier = Modifier.background(CurrentColors.background),
            isDarkTheme = isDarkTheme,
            onToggleTheme = onToggleTheme
        )
        Spacer(Modifier.weight(1f))
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


@Composable
fun PageLayout(viewportSize: ViewportSize, isPortrait: Boolean) {
    val listState = rememberLazyListState()
    /*
        TODO: remember for images for caching
     */
    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize().background(CurrentColors.background)
    ) {
        item {
            Box(modifier = Modifier.height(viewportSize.height.dp)) {
                Image(
                    painter =  painterResource(Res.drawable.backgroundImage10) ,
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.3f)))

                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    OutlinedText(text = "Adam Abdelaziz", modifier = Modifier.padding(bottom = 64.dp))
                    OutlinedText(text = "Software Engineer", fontSize = 48.sp)
                }
            }
        }

        item {
            if (isPortrait) {
                PortraitLayout(
                    modifier = Modifier.fillMaxWidth().height(viewportSize.height.dp)
                )
            } else {
                LandscapeLayout(
                    modifier = Modifier.fillMaxWidth().height(viewportSize.height.dp)
                )
            }
        }

        item {
            Box(modifier = Modifier.height(viewportSize.height.dp)) {
                Image(
                    painter = painterResource(Res.drawable.backgroundImage15),
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.3f)))
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Spacer(modifier =  Modifier.weight(1f))
                    Text("Site made with Compose for Web", fontSize = 32.sp, color = CurrentColors.onBackground, modifier = Modifier.padding(bottom = 64.dp))
                }
            }
        }
    }
}

/*
       Skills animation with similar box overlay and outlined text.
       Then very vertical project section that can be horizontally swiped through
    */
@Composable
fun PortraitLayout(
    modifier: Modifier = Modifier
) {

}

/*
       Left side skills text / animation on right
       Left side project stuff / text on right
       Each component half viewport height
     */

@Composable
fun LandscapeLayout(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth().weight(1f).background(CurrentColors.background).borderOnSides(sides = setOf(Side.Bottom))) {
            TextSection(
                modifier = Modifier.fillMaxHeight().weight(1f).background(CurrentColors.background).borderOnSides(sides = setOf(Side.Right, Side.Bottom)),
                text = "Skills"
            )
            RainingWordsAnimation(modifier = Modifier.fillMaxHeight().weight(3f).clipToBounds(), WORD_LIST)
        }
        Row(modifier = Modifier.fillMaxWidth().weight(1f).background(CurrentColors.background)) {
            ProjectPager(modifier = Modifier.fillMaxHeight().weight(3f) )
            TextSection(modifier = Modifier.fillMaxHeight().weight(1f).background(CurrentColors.background).borderOnSides(setOf(Side.Left)), text = "Project")
        }
    }
}

