package org.adam.resume.website

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.adam.resume.website.ui.components.WordStorm
import org.adam.resume.website.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            WordStorm(WORD_LIST)
        }
    }
}