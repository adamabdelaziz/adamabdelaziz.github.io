package org.adam.resume.website

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.adam.resume.website.ui.components.BouncingWordsAnimation
import org.adam.resume.website.ui.components.ParallaxImage
import org.adam.resume.website.ui.theme.AppTheme
import resumewebsite2025.composeapp.generated.resources.Res
import resumewebsite2025.composeapp.generated.resources.captain_pikachu

@Composable
fun App() {
    AppTheme {
        PageLayout()
    }
}


@Composable
fun PageLayout() {
    val listState = rememberLazyListState()
    var viewportHeight by remember { mutableStateOf(window.innerHeight.toDouble()) }

    LaunchedEffect(Unit) {
        window.addEventListener("resize", {
            viewportHeight = window.innerHeight.toDouble()
            println("Viewport height updated: $viewportHeight")
        })
    }

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Box(modifier = Modifier.height(viewportHeight.dp)) {
                ParallaxImage(
                    resource = Res.drawable.captain_pikachu,
                    scrollOffset = listState.firstVisibleItemScrollOffset,
                    heightPx = viewportHeight.dp
                )
                Text(text = "Big Placeholder", modifier = Modifier.align(Alignment.Center), color = Color.Red)
            }
        }

        item {
            BouncingWordsAnimation(modifier = Modifier.height(viewportHeight.dp.div(2)).padding(horizontal = 24.dp), WORD_LIST)
        }

        items(50) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(100.dp)
            ) {
                Text("Item $index")
            }
        }
    }
}
