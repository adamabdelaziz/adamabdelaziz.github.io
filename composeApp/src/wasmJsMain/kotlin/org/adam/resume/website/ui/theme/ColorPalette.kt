package org.adam.resume.website.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val primary: Color = Color(0xFF6200EE),
    val secondary: Color = Color(0xFF03DAC6),
    val background: Color = Color(0xFFFFFFFF),
    val surface: Color = Color(0xFFFFFFFF),
    val error: Color = Color(0xFFB00020),
    val onPrimary: Color = Color(0xFFFFFFFF),
    val onSecondary: Color = Color(0xFF000000),
    val onBackground: Color = Color(0xFF000000),
    val onSurface: Color = Color(0xFF000000),
    val onError: Color = Color(0xFFFFFFFF),

    // Add your custom colors here
    val warning: Color = Color(0xFFFF9800),
    val success: Color = Color(0xFF4CAF50),
    val listColors: List<Color>
)

val DarkColors = AppColors(
    primary = BarbiePurple,
    secondary = DarkTurquoise,
    background = CharcoalBlack,
    surface = CharcoalBlack,
    error = EmberGlow,
    onPrimary = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onBackground = SnowWhite,
    onSurface = SnowWhite,
    onError = Color(0xFF000000),
    listColors = PopArtDarkColors
)

val DarkColorsCute = AppColors(
    primary = PinkBlush,
    secondary = SkyMist,
    background = SlateNight,
    surface = TwilightShadow,
    error = EmberGlow,
    onPrimary = MidnightContrast,
    onSecondary = MidnightContrast,
    onBackground = SnowWhite,
    onSurface = SnowWhite,
    onError = MidnightContrast,
    warning = CoralSunset,
    success = MintHaven,
    listColors = PopArtDarkColors
)

val LightPastelAppColors = AppColors(
    primary = MidnightBlue,
    secondary = MintGreen,
    background = IcicleGray,
    surface = SoftWhite,
    error = Crimson,
    onPrimary = Color(0xFF333333),
    onSecondary = Color(0xFF333333),
    onBackground = Color(0xFF333333),
    onSurface = Color(0xFF333333),
    onError = SnowWhite,
    warning = BrightOrange,
    success = SkyMist,
    listColors = LightPastelColors
)

val DarkPastelAppColors = AppColors(
    primary = MutedLavender,
    secondary = PastelRose,
    background = SlateNight,
    surface = MauveShadow,
    error = Crimson,
    onPrimary = SoftWhite,
    onSecondary = SoftWhite,
    onBackground = SoftWhite,
    onSurface = SoftWhite,
    onError = SlateNight,
    warning = BrightOrange,
    success = StormyBlue,
    listColors = DarkPastelColors
)

val LightPopAppColors = AppColors(
    primary = VividRed,
    secondary = ElectricBlue,
    background = LemonFrost,
    surface = SoftSurface,
    error = FireRed,
    onPrimary = SnowWhite,
    onSecondary = CharcoalBlack,
    onBackground = Color(0xFF111111),
    onSurface = Color(0xFF111111),
    onError = SnowWhite,
    warning = BrightYellow,
    success = ForestGreen,
    listColors = PopArtLightColors
)

val DarkPopAppColors = AppColors(
    primary = DeepPink,
    secondary = DodgerBlue,
    background = MidnightBlue,
    surface = SlateNight,
    error = OrangeRed,
    onPrimary = SnowWhite,
    onSecondary = SnowWhite,
    onBackground = SnowWhite,
    onSurface = SnowWhite,
    onError = CharcoalBlack,
    warning = BrightOrange,
    success = NeonGreen,
    listColors = PopArtDarkColors
)


val LocalAppColors = staticCompositionLocalOf { DarkPastelAppColors }
