package org.adam.resume.website.ui.portrait

import androidx.compose.runtime.Composable
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.ui.theme.AppTheme
import org.adam.resume.website.ui.theme.DarkPastelAppColors
import org.adam.resume.website.ui.theme.LightPastelAppColors

@Composable
fun PortraitLayoutNew(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    AppTheme(colors = if (state.isDarkTheme) DarkPastelAppColors else LightPastelAppColors ) {
        /*
               TODO: Mobile App esque UI
            */
    }

}

