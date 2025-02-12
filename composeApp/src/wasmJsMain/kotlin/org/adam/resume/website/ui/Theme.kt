package org.adam.resume.website.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    colors: AppColors = DarkWinterColors,
    shapes: AppShapes = AppShapes(),
    typography: AppTypography = AppTypography(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppShapes provides shapes,
        LocalAppTypography provides  typography,
    ) {
        content()
    }
}