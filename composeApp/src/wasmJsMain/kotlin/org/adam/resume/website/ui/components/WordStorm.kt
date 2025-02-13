package org.adam.resume.website.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import kotlinx.coroutines.delay
import org.adam.resume.website.determineXOffset
import org.adam.resume.website.determineYOffset
import kotlin.random.Random

@Composable
fun WordStorm(wordList: List<String>) {
    var boxSize by remember { mutableStateOf(Size.Zero) }
    val wordPositions = remember { mutableStateListOf<MutableState<WordPosition>>() }

    LaunchedEffect(boxSize) {
        if (boxSize.width > 0) {
            wordPositions.clear()
            val angleStep = 360f / wordList.size
            val radius = boxSize.width * 0.11f // Keep words close to center

            wordList.forEachIndexed { index, word ->
                val angle = angleStep * index
                val offsetX = determineXOffset(angle, radius)
                val offsetY = determineYOffset(angle, radius)
                wordPositions.add(mutableStateOf(WordPosition(word, offsetX, offsetY)))
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned { coordinates ->
                boxSize = coordinates.size.toSize()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Skills",
            fontSize = 24.sp,
        )
        wordPositions.forEachIndexed { index, wordPositionState ->
            val wordPosition = wordPositionState.value

            // Mutable state for animated offsets
            var targetX by remember { mutableStateOf(wordPosition.x) }
            var targetY by remember { mutableStateOf(wordPosition.y) }

            val animatedX by animateFloatAsState(
                targetValue = targetX,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing),
                label = "animatedX_$index"
            )

            val animatedY by animateFloatAsState(
                targetValue = targetY,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing),
                label = "animatedY_$index"
            )

            // Periodically update the target position to make words float
            LaunchedEffect(Unit) {
                while (true) {
                    targetX = wordPosition.x + (5..15).random() * if (Random.nextBoolean()) 1 else -1
                    targetY = wordPosition.y + (5..15).random() * if (Random.nextBoolean()) 1 else -1
                    delay(2000) // Wait for animation to complete before updating again
                }
            }

            Text(
                text = wordPosition.word,
                fontSize = 24.sp,
                modifier = Modifier.offset(animatedX.dp, animatedY.dp)
            )
        }
    }
}

data class WordPosition(val word: String, val x: Float, val y: Float)