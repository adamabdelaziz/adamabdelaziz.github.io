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
    val success: Color = Color(0xFF4CAF50)
)


val LightColors = AppColors()

val DarkColors = AppColors(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    error = Color(0xFFCF6679),
    onPrimary = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFFFFFFF),
    onError = Color(0xFF000000)
)

val DarkColorsCute = AppColors(
    primary = PinkBlush,
    secondary = SkyMist,
    background = SlateNight,
    surface = TwilightShadow,
    error = EmberGlow,
    onPrimary = MidnightContrast,
    onSecondary = MidnightContrast,
    onBackground = Moonlight,
    onSurface = Moonlight,
    onError = MidnightContrast,
    warning = CoralSunset,
    success = MintHaven
)
val LightPastelAppColors = AppColors(
    primary = Color(0xFFFFB3BA), // Soft Pink
    secondary = Color(0xFFB5EAD7), // Mint Green
    background = Color(0xFFFFF1E6), // Pastel Cream
    surface = Color(0xFFFFFFFF),
    error = Color(0xFFE57373),
    onPrimary = Color(0xFF333333),
    onSecondary = Color(0xFF333333),
    onBackground = Color(0xFF333333),
    onSurface = Color(0xFF333333),
    onError = Color(0xFFFFFFFF),
    warning = Color(0xFFFFD580),
    success = Color(0xFFA5D6A7)
)


val DarkPastelAppColors = AppColors(
    primary = Color(0xFFBAA6D1), // Muted Lavender
    secondary = Color(0xFF80CBC4), // Muted Teal
    background = Color(0xFF2E2C38), // Mauve Shadow
    surface = Color(0xFF1E1E2E),
    error = Color(0xFFEF9A9A),
    onPrimary = Color(0xFFF2F2F2),
    onSecondary = Color(0xFFF2F2F2),
    onBackground = Color(0xFFF2F2F2),
    onSurface = Color(0xFFF2F2F2),
    onError = Color(0xFF1E1E1E),
    warning = Color(0xFFFFCC80),
    success = Color(0xFF81C784)
)


val LightPopAppColors = AppColors(
    primary = Color(0xFFFF0033), // Vivid Red
    secondary = Color(0xFF00BFFF), // Electric Blue
    background = Color(0xFFFFFDE7), // Lemon Frost
    surface = Color(0xFFFFF4E6),
    error = Color(0xFFFF6347),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFF000000),
    onBackground = Color(0xFF111111),
    onSurface = Color(0xFF111111),
    onError = Color(0xFFFFFFFF),
    warning = Color(0xFFFFC107),
    success = Color(0xFF4CAF50)
)

val DarkPopAppColors = AppColors(
    primary = Color(0xFFFF1493), // Deep Pink
    secondary = Color(0xFF1E90FF), // Dodger Blue
    background = Color(0xFF161636), // Indigo Ink
    surface = Color(0xFF1E1E2E),
    error = Color(0xFFFF6F61),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    onBackground = Color(0xFFFFF9F9),
    onSurface = Color(0xFFFFF9F9),
    onError = Color(0xFF000000),
    warning = Color(0xFFFFA500),
    success = Color(0xFF00FF00)
)


val LightColorsBlue = AppColors(
    primary = FrostbiteBlue,       // Bright icy blue
    secondary = IcicleGray,        // Soft steel blue
    background = SoftWhite,        // Light, airy background
    surface = Ivory,               // Warm creamy white for surfaces
    error = FrozenRed,             // Cool red for contrast
    onPrimary = CharcoalBlack,     // Ensuring dark text on blue primary
    onSecondary = MidnightBlue,    // Deep blue for secondary contrast
    onBackground = CharcoalBlack,  // Readable text color
    onSurface = DeepSlate,         // Slightly darkened for contrast
    onError = SnowWhite,           // Ensuring visibility for error messages
    warning = ArcticOrange,        // Bright orange for warnings
    success = PineGreen            // Cool deep green for success
)
val DarkColorsBlue = AppColors(
    primary = MidnightBlue,        // Deep, rich blue
    secondary = DeepIce,           // Very dark blue-gray
    background = CharcoalBlack,    // Dark background for contrast
    surface = DeepSlate,           // Muted dark surface color
    error = FrozenRed,             // Striking cool red for errors
    onPrimary = Moonlight,         // White text for dark elements
    onSecondary = IcicleGray,      // Soft blue for secondary contrast
    onBackground = SnowWhite,      // Light text for dark theme
    onSurface = SoftWhite,         // Gentle contrast
    onError = SnowWhite,           // High contrast error text
    warning = ArcticOrange,        // Bright, striking orange
    success = ForestGreen          // Deep green for success messages
)
val LightColorsCute = AppColors(
    primary = CoralSunset,         // Soft warm coral
    secondary = MintHaven,         // Refreshing pastel green
    background = SoftWhite,        // Gentle off-white
    surface = Ivory,               // Warm creamy white
    error = EmberGlow,             // Soft muted red
    onPrimary = CharcoalBlack,     // Strong contrast for readability
    onSecondary = MidnightBlue,    // Dark blue for contrast
    onBackground = CharcoalBlack,  // Ensuring dark text on light background
    onSurface = DeepSlate,         // Soft contrast for surfaces
    onError = SnowWhite,           // Bright error text
    warning = PumpkinSpice,        // Autumnal orange for warnings
    success = ForestGreen          // Natural green for success
)

val DarkColorsPumpkin = AppColors(
    primary = PumpkinSpice,
    secondary = BurntSienna,
    background = CharcoalBlack,
    surface = DeepSlate,
    error = EmberGlow,
    onPrimary = Ivory,
    onSecondary = Ivory,
    onBackground = SoftWhite,
    onSurface = SoftWhite,
    onError = Ivory,
    warning = HarvestGold,
    success = ForestGreen
)
val DarkWinterColors = AppColors(
    primary = FrostbiteBlue,
    secondary = IcicleGray,
    background = MidnightBlue,
    surface = DeepIce,
    error = FrozenRed,
    onPrimary = SnowWhite,
    onSecondary = SnowWhite,
    onBackground = SnowWhite,
    onSurface = SnowWhite,
    warning = ArcticOrange,
    success = PineGreen
)
val LocalAppColors = staticCompositionLocalOf { DarkPastelAppColors }
