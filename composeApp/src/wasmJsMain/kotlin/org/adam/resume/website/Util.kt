package org.adam.resume.website

import resumewebsite2025.composeapp.generated.resources.Res
import resumewebsite2025.composeapp.generated.resources.backgroundImage1
import resumewebsite2025.composeapp.generated.resources.backgroundImage10
import resumewebsite2025.composeapp.generated.resources.backgroundImage11
import resumewebsite2025.composeapp.generated.resources.backgroundImage12
import resumewebsite2025.composeapp.generated.resources.backgroundImage13
import resumewebsite2025.composeapp.generated.resources.backgroundImage14
import resumewebsite2025.composeapp.generated.resources.backgroundImage15
import resumewebsite2025.composeapp.generated.resources.backgroundImage16
import resumewebsite2025.composeapp.generated.resources.backgroundImage2
import resumewebsite2025.composeapp.generated.resources.backgroundImage3
import resumewebsite2025.composeapp.generated.resources.backgroundImage4
import resumewebsite2025.composeapp.generated.resources.backgroundImage5
import resumewebsite2025.composeapp.generated.resources.backgroundImage6
import resumewebsite2025.composeapp.generated.resources.backgroundImage7
import resumewebsite2025.composeapp.generated.resources.backgroundImage8
import resumewebsite2025.composeapp.generated.resources.backgroundImage9
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun determineXOffset(angle: Float, radius: Float): Float {
    return radius * cos(angle.toRadians())
}

fun determineYOffset(angle: Float, radius: Float): Float {
    return radius * sin(angle.toRadians())
}

fun Float.toRadians(): Float {
    return (this * (PI / 180.0)).toFloat()
}

fun openUrl(url: String) {
    js("window.open(url, '_blank')")
}


val WORD_LIST = listOf(
    "Kotlin",
    "GraphQL",
    "Koin",
    "Compose\nMultiplatform",
    "Kotlin\nMultiplatform",
    "Flows",
    "Coroutines",
    "Dagger\nHilt",
    "Jetpack\nCompose",
    "Retrofit",
    "MVVM",
)

val GOOD_IMAGE_LIST = listOf(
    Res.drawable.backgroundImage3,
    Res.drawable.backgroundImage10,
    Res.drawable.backgroundImage14,
    Res.drawable.backgroundImage15,
)
val LIGHT_IMAGE_LIST = listOf(
    Res.drawable.backgroundImage3,
    Res.drawable.backgroundImage4,
    Res.drawable.backgroundImage5,
    Res.drawable.backgroundImage6,
    Res.drawable.backgroundImage7,
    Res.drawable.backgroundImage8,
    Res.drawable.backgroundImage10,
    Res.drawable.backgroundImage11,
    Res.drawable.backgroundImage12,
    Res.drawable.backgroundImage14,
    Res.drawable.backgroundImage15,
)

val DARK_IMAGE_LIST = listOf(
    Res.drawable.backgroundImage1,
    Res.drawable.backgroundImage2,
    Res.drawable.backgroundImage9,
    Res.drawable.backgroundImage13,
    Res.drawable.backgroundImage16
)