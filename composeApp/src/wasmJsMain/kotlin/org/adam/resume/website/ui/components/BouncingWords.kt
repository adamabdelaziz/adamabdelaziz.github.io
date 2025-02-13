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
import kotlin.random.Random

@Composable
fun BouncingWordsAnimation(words: List<String>) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val containerSize = IntSize(constraints.maxWidth, constraints.maxHeight)

        words.forEach { word ->
            val color = remember { randomColor() }
            val velocity = remember { randomVelocity() }
            BouncingWord(word, containerSize, color, velocity)
        }
    }
}

@Composable
fun BouncingWord(word: String, containerSize: IntSize, color: Color, initialVelocity: Offset) {
    val positionX = remember { Animatable(Random.nextFloat() * containerSize.width) }
    val positionY = remember { Animatable(Random.nextFloat() * containerSize.height) }
    var velocity by remember { mutableStateOf(initialVelocity) }
    val textSize = 80.dp
    val density = LocalDensity.current

    LaunchedEffect(Unit) {
        while (true) {
            val textSizePx = with(density) { textSize.toPx() }

            positionX.snapTo(positionX.value + velocity.x)
            positionY.snapTo(positionY.value + velocity.y)

            if (positionX.value <= 0 || positionX.value + textSizePx >= containerSize.width) {
                velocity = velocity.copy(x = -velocity.x)
            }
            if (positionY.value <= 0 || positionY.value + textSizePx >= containerSize.height) {
                velocity = velocity.copy(y = -velocity.y)
            }

            withFrameNanos { }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier
                .offset(positionX.value.dp, positionY.value.dp)
                .clip(CircleShape),
            color = color
        ) {
            Text(
                text = word,
                style = TextStyle(color = Color.White, fontSize = 20.sp),
                modifier = Modifier.padding(8.dp)
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

private fun randomPosition(containerSize: IntSize) = Offset(
    Random.nextFloat() * containerSize.width,
    Random.nextFloat() * containerSize.height
)

private fun randomVelocity() = Offset(
    (Random.nextFloat() * 2 + 1) * if (Random.nextBoolean()) 1 else -1,
    (Random.nextFloat() * 2 + 1) * if (Random.nextBoolean()) 1 else -1
)