package org.adam.resume.website.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.adam.resume.website.ui.theme.CurrentColors
import kotlin.random.Random

@Composable
fun RainingWordsAnimation(modifier: Modifier = Modifier, words: List<String>) {
    BoxWithConstraints(modifier = modifier) {
        val containerSize = IntSize(constraints.maxWidth, constraints.maxHeight)

        words.forEach { word ->
            RainingWord(word, containerSize)
        }
    }
}

@Composable
fun RainingWord(word: String, containerSize: IntSize) {
    val textSize = 60.dp
    val density = LocalDensity.current
    val textSizePx = with(density) { textSize.toPx() }
    val padding = 16.dp
    val paddingPx = with(density) { padding.toPx() }
    val colors = CurrentColors
    val initialX = remember {
        Random.nextFloat() * (containerSize.width - textSizePx - paddingPx * 2) + paddingPx
    }

    val positionX = remember { Animatable(initialX) }
    val positionY = remember { Animatable(0f) }

    var color by remember { mutableStateOf(colors.listColors.random()) }
    var velocity by remember { mutableStateOf(randomVelocity()) }

    LaunchedEffect(Unit) {
        while (true) {
            positionY.snapTo(positionY.value + velocity.y)

            if (positionY.value > containerSize.height) {
                delay(500)

                color = randomColor()
                velocity = randomVelocity()

                val newX = Random.nextFloat() * (containerSize.width - textSizePx - paddingPx * 2) + paddingPx
                positionX.snapTo(newX)
                positionY.snapTo(-textSizePx)
            }

            withFrameNanos { }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier
                .offset(positionX.value.dp, positionY.value.dp)
                .padding(16.dp)
                .clip(CircleShape),
            color = color
        ) {
            Text(
                text = word,
                style = TextStyle(color = Color.White, fontSize = 20.sp),
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}

private fun randomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}

private fun randomVelocity(): Offset {
    return Offset(0f, Random.nextFloat() * 1.3f + 1f)
}