package org.adam.resume.website.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppDimensions(
    val spacingTiny: Dp,
    val spacingSmall: Dp,
    val spacingMedium: Dp,
    val spacingLarge: Dp,
    val spacingExtraLarge: Dp,
    val screenPadding: Dp,
    val cardPadding: Dp,
    val buttonPadding: Dp,
    val textPadding: Dp,
    val listItemPadding: Dp,
    val buttonHeight: Dp,
    val appBarHeight: Dp,
    val iconSizeSmall: Dp,
    val iconSizeMedium: Dp,
    val iconSizeLarge: Dp,
    val minTouchTargetSize: Dp,
    val defaultCornerRadius: Dp,
    val cardCornerRadius: Dp,
    val buttonCornerRadius: Dp,
    val shapeLargeCornerRadius: Dp,
    val defaultElevation: Dp,
    val cardElevation: Dp,
    val appBarElevation: Dp,
    val contentMaxWidth: Dp,
    val imageMaxWidth: Dp,
)

val CompactDimensions = AppDimensions(
    spacingTiny = 4.dp,
    spacingSmall = 8.dp,
    spacingMedium = 16.dp,
    spacingLarge = 24.dp,
    spacingExtraLarge = 32.dp,
    screenPadding = 16.dp,
    cardPadding = 12.dp,
    buttonPadding = 16.dp,
    textPadding = 4.dp,
    listItemPadding = 12.dp,
    buttonHeight = 48.dp,
    appBarHeight = 56.dp,
    iconSizeSmall = 18.dp,
    iconSizeMedium = 24.dp,
    iconSizeLarge = 32.dp,
    minTouchTargetSize = 48.dp,
    defaultCornerRadius = 8.dp,
    cardCornerRadius = 12.dp,
    buttonCornerRadius = 24.dp,
    shapeLargeCornerRadius = 16.dp,
    defaultElevation = 1.dp,
    cardElevation = 2.dp,
    appBarElevation = 4.dp,
    contentMaxWidth = Dp.Unspecified,
    imageMaxWidth = Dp.Unspecified
)

val MediumDimensions = AppDimensions(
    spacingTiny = 6.dp,
    spacingSmall = 12.dp,
    spacingMedium = 20.dp,
    spacingLarge = 32.dp,
    spacingExtraLarge = 48.dp,
    screenPadding = 24.dp,
    cardPadding = 16.dp,
    buttonPadding = 20.dp,
    textPadding = 6.dp,
    listItemPadding = 16.dp,
    buttonHeight = 56.dp,
    appBarHeight = 64.dp,
    iconSizeSmall = 20.dp,
    iconSizeMedium = 28.dp,
    iconSizeLarge = 40.dp,
    minTouchTargetSize = 48.dp,
    defaultCornerRadius = 10.dp,
    cardCornerRadius = 16.dp,
    buttonCornerRadius = 28.dp,
    shapeLargeCornerRadius = 24.dp,
    defaultElevation = 2.dp,
    cardElevation = 4.dp,
    appBarElevation = 6.dp,
    contentMaxWidth = 720.dp,
    imageMaxWidth = 500.dp
)

val ExpandedDimensions = AppDimensions(
    spacingTiny = 8.dp,
    spacingSmall = 16.dp,
    spacingMedium = 24.dp,
    spacingLarge = 40.dp,
    spacingExtraLarge = 64.dp,
    screenPadding = 32.dp,
    cardPadding = 24.dp,
    buttonPadding = 24.dp,
    textPadding = 8.dp,
    listItemPadding = 20.dp,
    buttonHeight = 64.dp,
    appBarHeight = 72.dp,
    iconSizeSmall = 24.dp,
    iconSizeMedium = 32.dp,
    iconSizeLarge = 48.dp,
    minTouchTargetSize = 96.dp,
    defaultCornerRadius = 12.dp,
    cardCornerRadius = 20.dp,
    buttonCornerRadius = 32.dp,
    shapeLargeCornerRadius = 28.dp,
    defaultElevation = 3.dp,
    cardElevation = 6.dp,
    appBarElevation = 8.dp,
    contentMaxWidth = 960.dp,
    imageMaxWidth = 700.dp
)

val LocalAppDimensions = compositionLocalOf { ExpandedDimensions }