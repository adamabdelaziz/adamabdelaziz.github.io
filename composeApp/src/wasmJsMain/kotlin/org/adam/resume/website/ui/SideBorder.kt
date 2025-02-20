package org.adam.resume.website.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.adam.resume.website.ui.theme.CurrentColors

@Composable
fun Modifier.borderOnSides(
    sides: Set<Side>,
    color: Color = CurrentColors.secondary,
    borderWidth: Dp = 2.dp,
): Modifier = this.then(
    Modifier.drawBehind {
        val strokeWidth = borderWidth.toPx()
        val width = size.width
        val height = size.height

        val start = strokeWidth / 2
        val endX = width - strokeWidth / 2
        val endY = height - strokeWidth / 2

        val path = Path().apply {
            if (Side.Top in sides) {
                moveTo(0f, start)
                lineTo(width, start)
            }
            if (Side.Bottom in sides) {
                moveTo(0f, endY)
                lineTo(width, endY)
            }
            if (Side.Left in sides) {
                moveTo(start, 0f)
                lineTo(start, height)
            }
            if (Side.Right in sides) {
                moveTo(endX, 0f)
                lineTo(endX, height)
            }
        }

        drawPath(path, color, style = Stroke(width = strokeWidth))
    }
)

enum class Side {
    Top, Bottom, Left, Right
}
