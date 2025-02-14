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

val SQURITLE_SQUAD = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/4d1f087a-24b4-47a0-906b-7f66a07311f9/d631mb4-3de5b9dc-7ad4-409d-9e10-5d17ebc38afe.png/v1/fill/w_1131,h_707,q_70,strp/here_comes_the_squirtle_squad_by_ishmam_d631mb4-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTgwMCIsInBhdGgiOiJcL2ZcLzRkMWYwODdhLTI0YjQtNDdhMC05MDZiLTdmNjZhMDczMTFmOVwvZDYzMW1iNC0zZGU1YjlkYy03YWQ0LTQwOWQtOWUxMC01ZDE3ZWJjMzhhZmUucG5nIiwid2lkdGgiOiI8PTI4ODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.ayblRMVjgTSU9pdOwFVrblTCbp7834JjVKZdiEjj37M"