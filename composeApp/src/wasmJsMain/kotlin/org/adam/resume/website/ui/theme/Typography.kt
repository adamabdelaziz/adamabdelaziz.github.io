package org.adam.resume.website.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    val overline: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)
val BaseTypography = AppTypography()
val CompactTypography = AppTypography(
    h1 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
    h2 = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
    h3 = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
    body1 = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
    body2 = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
    button = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Medium),
    caption = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Normal),
    overline = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Normal),
)

val MediumTypography = AppTypography(
    h1 = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
    h2 = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
    h3 = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
    body1 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
    body2 = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
    button = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
    caption = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
    overline = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Normal),
)

val ExpandedTypography = AppTypography(
    h1 = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
    h2 = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Bold),
    h3 = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Medium),
    body1 = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal),
    body2 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
    button = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
    caption = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Normal),
    overline = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Normal),
)

val LocalAppTypography = compositionLocalOf { AppTypography() }