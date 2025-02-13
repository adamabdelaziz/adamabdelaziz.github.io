package org.adam.resume.website.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import org.adam.resume.website.determineXOffset
import org.adam.resume.website.determineYOffset
import org.adam.resume.website.toRadians
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun WordStorm(wordList: List<String>) {
    var boxSize by remember { mutableStateOf(Size.Zero) }
    val wordPositions = remember { mutableStateListOf<WordPosition>() }

    LaunchedEffect(boxSize) {
        if (boxSize.width > 0) {
            wordPositions.clear()
            val angleStep = 360f / wordList.size
            val radius = boxSize.width * 0.12f

            wordList.forEachIndexed { index, word ->
                val angle = angleStep * index
                val offsetX = determineXOffset(angle, radius)
                val offsetY = determineYOffset(angle, radius)
                wordPositions.add(WordPosition(word, offsetX, offsetY))
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned { coordinates ->
                boxSize = coordinates.size.toSize()
            }
    ) {
        val centerX = boxSize.width / 2
        val centerY = boxSize.height / 2

        wordPositions.forEachIndexed { index, wordPosition ->
            val baseX = wordPosition.x
            val baseY = wordPosition.y

            val floatingX by rememberInfiniteTransition(label = "floatingX").animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = (6000..8000).random(), easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                ),
                label = "floatingX_$index"
            )

            val floatingY by rememberInfiniteTransition(label = "floatingY").animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = (6000..8000).random(), easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                ),
                label = "floatingY_$index"
            )

            val animatedOffsetX = (sin(floatingX.toRadians()) * 15).toFloat()
            val animatedOffsetY = (cos(floatingY.toRadians()) * 15).toFloat()

            val cloudCenterX = centerX + baseX + animatedOffsetX
            val cloudCenterY = centerY + baseY + animatedOffsetY

            val textMeasurer = rememberTextMeasurer()
            val textSize = textMeasurer.measure(wordPosition.word, TextStyle(fontSize = 24.sp))
            val textWidth = textSize.size.width.toFloat()
            val cloudWidth = textWidth * 1.5f

            val cloudHeight = textSize.size.height.toFloat() * 2.5f

            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    color = Color.Gray.copy(alpha = 0.5f),
                    start = Offset(centerX, centerY),
                    end = Offset(cloudCenterX, cloudCenterY - cloudHeight / 3),
                    strokeWidth = 3f
                )
            }

            Box(
                modifier = Modifier
                    .offset((cloudCenterX - cloudWidth / 2).dp, (cloudCenterY - cloudHeight / 2).dp)
                    .size(cloudWidth.dp, cloudHeight.dp)
            ) {
                CloudShape(text = wordPosition.word, modifier = Modifier.fillMaxSize())

                Text(
                    text = wordPosition.word,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Text(
            text = "Skills",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun CloudShape(text: String, modifier: Modifier = Modifier) {
    val textMeasurer = rememberTextMeasurer()

    val textSize = textMeasurer.measure(text, TextStyle(fontSize = 24.sp))
    val textWidth = textSize.size.width.toFloat()
    val textHeight = textSize.size.height.toFloat()

    val cloudWidth = textWidth * 1.6f
    val cloudHeight = textHeight * 2.2f

    val fluffs = remember(text) {
        val numFluffs = (cloudWidth / (textHeight * 0.9f)).roundToInt().coerceAtLeast(5)
        val fluffSpacing = cloudWidth / (numFluffs + 1)
        val baseFluffRadius = cloudHeight * 0.3f

        List(numFluffs) { i ->
            val xPosition = fluffSpacing * (i + 1)
            val randomSizeFactor = Random.nextFloat() * (1.2f - 0.85f) + 0.85f
            val fluffRadius = baseFluffRadius * randomSizeFactor
            val yPosition = cloudHeight * (0.3f + Random.nextFloat() * 0.1f)

            FluffData(xPosition, fluffRadius, yPosition)
        }
    }

    Canvas(modifier = modifier.size(cloudWidth.dp, cloudHeight.dp)) {
        val cloudColor = Color.Gray.copy(alpha = 0.95f)

//        drawOval(
//            color = cloudColor,
//            topLeft = Offset(0f, cloudHeight * 0.3f),
//            size = Size(cloudWidth, cloudHeight * 0.6f)
//        )

        fluffs.forEach { fluff ->
            drawCircle(
                color = cloudColor,
                radius = fluff.radius,
                center = Offset(fluff.x, fluff.y)
            )
        }

        fluffs.forEach { fluff ->
            drawCircle(
                color = cloudColor,
                radius = fluff.radius * 0.8f,
                center = Offset(fluff.x, cloudHeight * 0.7f)
            )
        }
    }
}

data class FluffData(val x: Float, val radius: Float, val y: Float)
data class WordPosition(val word: String, val x: Float, val y: Float)