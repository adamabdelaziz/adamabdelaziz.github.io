package org.adam.resume.website.ui.theme

import androidx.compose.runtime.Composable

val CurrentColors: AppColors
    @Composable
    get() = LocalAppColors.current

val CurrentShapes: AppShapes
    @Composable
    get() = LocalAppShapes.current

val CurrentTypography: AppTypography
    @Composable
    get() = LocalAppTypography.current