package org.adam.resume.website

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