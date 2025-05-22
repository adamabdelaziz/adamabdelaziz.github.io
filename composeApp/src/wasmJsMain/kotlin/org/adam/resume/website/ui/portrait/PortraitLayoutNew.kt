package org.adam.resume.website.ui.portrait

import androidx.compose.runtime.Composable
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.ui.theme.AppTheme
import org.adam.resume.website.ui.theme.DarkColorsBlue
import org.adam.resume.website.ui.theme.LightColorsBlue

@Composable
fun PortraitLayoutNew(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    AppTheme(colors = if (state.isDarkTheme) DarkColorsBlue else LightColorsBlue) {
        /*
               TODO: Mobile App esque UI
            */
    }

}

