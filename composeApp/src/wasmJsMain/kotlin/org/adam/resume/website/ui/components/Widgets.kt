package org.adam.resume.website.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Github
import compose.icons.feathericons.Linkedin
import compose.icons.feathericons.Mail
import compose.icons.feathericons.Moon
import compose.icons.feathericons.Paperclip
import compose.icons.feathericons.Sun
import org.adam.resume.website.GITHUB_URL
import org.adam.resume.website.LINKEDIN_URL
import org.adam.resume.website.openEmail
import org.adam.resume.website.openPdf
import org.adam.resume.website.openUrl
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentShapes
import org.adam.resume.website.ui.theme.CurrentTypography
import org.jetbrains.compose.resources.painterResource
import resumewebsite2025.composeapp.generated.resources.Res
import resumewebsite2025.composeapp.generated.resources.backgroundImage10
import resumewebsite2025.composeapp.generated.resources.backgroundImage15

@Composable
fun HeaderIcon(
    modifier: Modifier = Modifier.size(64.dp).padding(end = 16.dp),
    onClick: () -> Unit,
    imageVector: ImageVector,
    tint: Color = CurrentColors.onBackground
) {
    IconButton(
        modifier = modifier.pointerHoverIcon(PointerIcon.Hand),
        onClick = onClick,
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            tint = tint,
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HeaderIconExtended(
    onClick: () -> Unit,
    imageVector: ImageVector,
    label: String,
    modifier: Modifier = Modifier,
    tint: Color = CurrentColors.onBackground
) {
    var isHovered by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .clip(CurrentShapes.pill)
            .background(if (isHovered) CurrentColors.background else Color.Transparent)
            .animateContentSize()
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable {
                onClick()
            }
            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false },
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier.size(64.dp),
                onClick = onClick,
            ) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = tint
                )
            }

            AnimatedVisibility(visible = isHovered) {
                Text(
                    text = label,
                    modifier = Modifier.padding(start = 24.dp),
                    color = tint,
                    style = CurrentTypography.h3,
                )
            }
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
                onClick = { openUrl(GITHUB_URL) },
                imageVector = FeatherIcons.Github,
            )
            HeaderIcon(
                onClick = { openUrl(LINKEDIN_URL) },
                imageVector = FeatherIcons.Linkedin,
            )
            HeaderIcon(
                onClick = { openEmail() },
                imageVector = FeatherIcons.Mail,
            )
            HeaderIcon(
                onClick = { openPdf() },
                imageVector = FeatherIcons.Paperclip,
            )
        }
    }
}


@Composable
fun IconColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeaderIconExtended(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { openUrl(GITHUB_URL) },
            imageVector = FeatherIcons.Github,
            label = "Github"
        )
        HeaderIconExtended(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { openUrl(LINKEDIN_URL) },
            imageVector = FeatherIcons.Linkedin,
            label = "LinkedIn"
        )
        HeaderIconExtended(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { openEmail() },
            imageVector = FeatherIcons.Mail,
            label = "E-Mail Me"
        )
        HeaderIconExtended(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { openPdf() },
            imageVector = FeatherIcons.Paperclip,
            label = "My Resume"
        )

        Text("Site made with Compose for Web", fontSize = 24.sp, color = CurrentColors.onBackground, modifier = Modifier.padding(bottom = 16.dp))
        Text(
            "All photographs used were taken by me",
            fontSize = 16.sp,
            color = CurrentColors.onBackground,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}


@Composable
fun ThemeSwitch(modifier: Modifier = Modifier, isDarkTheme: Boolean = true, onToggleTheme: (Boolean) -> Unit = {}) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = FeatherIcons.Sun,
            contentDescription = null,
            modifier = Modifier.size(64.dp).padding(end = 16.dp),
            tint = CurrentColors.onBackground
        )
        Switch(
            modifier = Modifier.padding(end = 16.dp),
            checked = isDarkTheme,
            onCheckedChange = onToggleTheme,
            colors = SwitchDefaults.colors()
        )
        Icon(
            imageVector = FeatherIcons.Moon,
            contentDescription = null,
            modifier = Modifier.size(64.dp).padding(end = 16.dp),
            tint = CurrentColors.onBackground
        )
    }
}

@Composable
fun TextSection(
    modifier: Modifier = Modifier,
    text: String,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = text, fontSize = 32.sp, style = CurrentTypography.h2, color = CurrentColors.onBackground, textAlign = TextAlign.Center)
    }
}


@Composable
fun TopLanding(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(Res.drawable.backgroundImage10),
            contentDescription = "Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.5f)))
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedText(text = "Adam Abdelaziz", modifier = Modifier.padding(bottom = 64.dp))
            OutlinedText(text = "Software Engineer", fontSize = 48.sp)
        }
    }
}

@Composable
fun BottomLanding(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(Res.drawable.backgroundImage15),
            contentDescription = "Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.5f)))
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconColumn(
                modifier = Modifier.background(color = CurrentColors.secondary, shape = RoundedCornerShape(48.dp)).fillMaxWidth(0.3f).padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}