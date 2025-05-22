package org.adam.resume.website.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.adam.resume.website.ui.theme.CurrentColors

@Composable
fun <T> BouncyAnimatedSurfaceContent(
    modifier: Modifier = Modifier,
    targetState: T,
    label: String = "BouncyAnimatedSurfaceContent",
    surfaceColor: Color = CurrentColors.surface,
    cornerRadius: Dp = 48.dp,
    content: @Composable ColumnScope.(T) -> Unit
) {
    AnimatedContent(
        modifier = modifier,
        targetState = targetState,
        transitionSpec = {
            (scaleIn(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ) togetherWith fadeOut())
                .using(SizeTransform(clip = false))
        },
        label = label
    ) { state ->
        state?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        shape = RoundedCornerShape(cornerRadius),
                        color = surfaceColor
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content(it)
            }
        }
    }
}
