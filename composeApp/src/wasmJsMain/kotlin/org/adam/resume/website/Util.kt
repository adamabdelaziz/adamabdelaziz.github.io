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

fun openPdf() = openUrl(RESUME_URL)

fun openEmail(to: String = "adam.a.abdelaziz@gmail.com", subject: String = "From your GitHub page", body: String = "") {
    val mailtoLink = "mailto:$to?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(body)}"
    openUrl(mailtoLink)
}

@JsFun("encodeURIComponent")
external fun encodeURIComponent(str: String): String

const val GITHUB_URL = "https://github.com/adamabdelaziz"
const val LINKEDIN_URL = "https://www.linkedin.com/in/adam-abdelaziz/"
const val RESUME_URL = "https://adamabdelaziz.github.io/ResumeWebsite/static/AdamAbdelazizResume.pdf" //TODO: Change when replacing old website

val WORD_LIST = listOf(
    "Kotlin",
    "GraphQL",
    "Koin",
    "Compose\nMultiplatform",
    "Kotlin\nMultiplatform",
    "Spring\nBoot",
    "Flows",
    "LiveData",
    "Coroutines",
    "Dagger\nHilt",
    "Ktor",
    "Room",
    "SQL",
    "Firebase",
    "Jetpack\nCompose",
    "Retrofit",
    "MVVM",
    "MVI",
    "TDD",
    "Espresso",
    "Use Cases",
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