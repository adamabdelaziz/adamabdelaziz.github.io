package org.adam.resume.website.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedText(
    text: String,
    fontSize: TextUnit = 64.sp,
    textColor: Color = Color.White,
    outlineColor: Color = Color.Black,
    outlineWidth: Float = 4f,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()

    Canvas(modifier = modifier) {
        val textLayout = textMeasurer.measure(
            text = text,
            style = TextStyle(fontSize = fontSize)
        )

        val centerX = (size.width - textLayout.size.width) / 2
        val centerY = (size.height - textLayout.size.height) / 2

        val centerOffset = Offset(centerX, centerY)

        for (dx in listOf(-1, 0, 1)) {
            for (dy in listOf(-1, 0, 1)) {
                if (dx == 0 && dy == 0) continue
                drawText(
                    textLayout,
                    topLeft = centerOffset + Offset(dx * outlineWidth, dy * outlineWidth),
                    color = outlineColor
                )
            }
        }

        drawText(textLayout, topLeft = centerOffset, color = textColor)
    }
}