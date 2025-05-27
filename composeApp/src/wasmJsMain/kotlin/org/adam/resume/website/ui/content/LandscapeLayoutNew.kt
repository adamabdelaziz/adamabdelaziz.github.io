package org.adam.resume.website.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.ui.components.HeaderRowNew
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
                    ContactSection(
                        Modifier
                            .fillMaxSize()
                            .background(color = CurrentColors.background, shape = RoundedCornerShape(24.dp)), state, onEvent
                    )
                }
                Column(modifier = Modifier.weight(2f).fillMaxHeight()) {
                    ContentSection(state, onEvent)
                }
            }
        }
    }
}



