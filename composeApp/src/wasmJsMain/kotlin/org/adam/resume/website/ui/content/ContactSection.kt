package org.adam.resume.website.ui.content

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.ui.components.IconColumn
import org.adam.resume.website.ui.components.OutlinedText

@Composable
fun ContactSection(
    modifier: Modifier = Modifier,
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(64.dp))
        OutlinedText(
            text = "Adam Abdelaziz",
            modifier = Modifier.padding(bottom = 64.dp),
        )
        AnimatedContent(
            modifier = Modifier.padding(bottom = 64.dp),
            targetState = state.outlinedText,
            transitionSpec = {
                (scaleIn(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) togetherWith fadeOut())
                    .using(SizeTransform(clip = false))
            },
            label = "OutlinedTextTransition"
        ) {
            OutlinedText(text = it, fontSize = 48.sp)
        }
        IconColumn()
    }
}
