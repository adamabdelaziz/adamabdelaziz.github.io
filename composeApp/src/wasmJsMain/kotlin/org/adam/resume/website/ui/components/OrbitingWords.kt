package org.adam.resume.website.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import org.adam.resume.website.ui.theme.CurrentDimensions
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun OrbitingWords(modifier: Modifier = Modifier, words: List<String>, colors: List<Color>, textColor: Color, fontSize: TextUnit = 20.sp) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val containerSize = IntSize(constraints.maxWidth, constraints.maxHeight)
        val center = Offset(containerSize.width / 2f, containerSize.height / 2f)

        val items = remember(words, colors) {
            val baseRadius = min(containerSize.width, containerSize.height) / 3f
            val halfCount = words.size / 2
            words.mapIndexed { index, word ->
                val baseAngle = 360f * (index % halfCount) / halfCount
                val angleOffset = Random.nextFloat() * 15f - 7.5f
                val radiusOffset = if (index < halfCount) 0f else 80f

                OrbitingItemState(
                    word = word,
                    radius = baseRadius + radiusOffset + Random.nextFloat() * 60f - 30f,
                    speed = 0.3f + Random.nextFloat() * 0.3f,
                    angle = baseAngle + angleOffset,
                    color = colors.random(),
                    clockwise = index < halfCount
                )
            }
        }

        LaunchedEffect(items) {
            while (isActive) {
                items.forEach { item ->
                    item.angle = if (item.clockwise) {
                        (item.angle + item.speed) % 360f
                    } else {
                        (item.angle - item.speed + 360f) % 360f
                    }
                }
                delay(8)
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            items.forEach { item ->
                OrbitingWord(item = item, textColor = textColor, fontSize = fontSize)
            }
        }
    }
}

private class OrbitingItemState(
    val word: String,
    val radius: Float,
    val speed: Float,
    val color: Color,
    angle: Float,
    val clockwise: Boolean
) {
    var angle by mutableStateOf(angle)
}

@Composable
private fun OrbitingWord(item: OrbitingItemState, textColor: Color, fontSize: TextUnit = 20.sp) {
    val radians = (item.angle * PI / 180).toFloat()
    val offsetX = item.radius * cos(radians)
    val offsetY = item.radius * sin(radians)

    Surface(
        modifier = Modifier
            .offset {
                IntOffset(offsetX.toInt(), offsetY.toInt())
            }
            .clip(CircleShape),
        color = item.color
    ) {
        Text(
            text = item.word,
            style = TextStyle(color = textColor, fontSize = fontSize),
            modifier = Modifier.padding(CurrentDimensions.spacingMedium)
        )
    }
}