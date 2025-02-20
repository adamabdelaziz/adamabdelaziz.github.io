package org.adam.resume.website.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Moon
import compose.icons.feathericons.Sun
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentTypography

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
        Text(text = text, fontSize = 32.sp, style = CurrentTypography.h2, color = CurrentColors.onBackground)
    }
}


