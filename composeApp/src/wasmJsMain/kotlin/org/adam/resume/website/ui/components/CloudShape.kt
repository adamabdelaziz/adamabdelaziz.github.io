package org.adam.resume.website.ui.components

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CloudShape(private val width: Float, private val height: Float) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(
            path = Path().apply {
                val w = width * 1.3f
                val h = height * 1.6f

                moveTo(w * 0.2f, h * 0.75f)

                cubicTo(
                    w * 0.1f, h * 0.5f,
                    w * 0.3f, h * 0.3f,
                    w * 0.4f, h * 0.4f
                )

                cubicTo(
                    w * 0.5f, h * 0.2f,
                    w * 0.7f, h * 0.2f,
                    w * 0.75f, h * 0.4f
                )

                cubicTo(
                    w * 0.85f, h * 0.3f,
                    w * 0.95f, h * 0.5f,
                    w * 0.8f, h * 0.75f
                )

                cubicTo(
                    w * 0.65f, h * 0.95f,
                    w * 0.35f, h * 0.95f,
                    w * 0.2f, h * 0.75f
                )

                close()
            }
        )
    }
}